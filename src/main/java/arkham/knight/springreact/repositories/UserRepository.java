package arkham.knight.springreact.repositories;

import arkham.knight.springreact.nodels.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Client,Long> {
}
