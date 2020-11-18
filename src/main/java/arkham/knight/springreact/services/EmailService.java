package arkham.knight.springreact.services;

import arkham.knight.springreact.models.User;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    final String user="fillclick@alternard.com";


    public void sendEmail(String to, String subject, String html)
    {
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", "smtp.yandex.ru");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.imaps.partialfetch", "false");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getDefaultInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(user, "alterna.1234");
            }
        });


        try {

            MimeMessage email = new MimeMessage(session);

            //Email configuration
            email.setFrom(new InternetAddress(user));
            email.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            email.setSubject(subject);
            email.setContent(html, "text/html");

            // Send message
            Transport.send(email);
            System.out.println("Sent message successfully....");
        } catch (MessagingException exception) {
            exception.printStackTrace();
        }
    }


    public void sendVerificationEmail(User user, String origin)
    {
        String verifyUrl = "https://safezona.alterna.com/verify-email?token="+"User.VerificationToken";
         /*if(_env.IsProduction())
                verifyUrl = $"https://safezona.alterna.com/verify-email?token={User.VerificationToken}";*/

        String message = "<p>Please click the below link to verify your email address:</p> <p><a href="+verifyUrl+">"+verifyUrl+"</a></p>";

        sendEmail(user.getName(), "Sign-up Verification Safezona", "<h4>Verify Email</h4> <p>Thanks for registering!</p>" + message);
    }


    public void sendAlreadyRegisteredEmail(String email, String origin)
    {
        String message = "<p>If you don't know your password please visit the <a href=\"https://safezona.alterna.com/forgot-password\">forgot password</a> page.</p>";
        /*if (_env.IsProduction())
                message = $@"<p>If you don't know your password please visit the <a href=""https://www.hazlacita.com/forgot-password"">forgot password</a> page.</p>";*/
            /*else
                message = "<p>If you don't know your password you can reset it via the <code>/User/forgot-password</code> api route.</p>";*/

        sendEmail(email, "Sign-up Verification Safezona.com- Email Already Registered", "<h4>Email Already Registered</h4> <p>Your email <strong>"+email+"</strong> is already registered.</p>" + message);
    }


    public void sendPasswordResetEmail(User user, String origin)
    {
        String resetUrl = "https://safezona.alterna.com/reset-password?token="+"User.ResetToken";
            /*if (_env.IsProduction())
                resetUrl = $"https://www.hazlacita.com/reset-password?token={User.ResetToken}";*/

        String message = "<p>Please click the below link to reset your password, the link will be valid for 1 day:</p>\n" + "<p><a href="+resetUrl+">"+resetUrl+"</a></p>";


        sendEmail(user.getName(), "SafeZona.com - Reset Password", "<h4>Reset Password Email</h4>" + message);
    }
}
