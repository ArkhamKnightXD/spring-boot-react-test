package arkham.knight.springreact.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@getter, setter y los constructor son para no tener que escribir en codigo estos elementos ya que con la libreria l
// lombok no es necesario que se escriban en la clase si deseamos utilizar estos elementos
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastName;
}
