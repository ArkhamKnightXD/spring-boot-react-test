package arkham.knight.springreact.repositories;

import arkham.knight.springreact.nodels.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
