package spring.security.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

/**
 * @Created 17 / 03 / 2020 - 6:46 PM
 * @project BootSecure
 * @Author Hamdamboy
 */
public interface UserRepository extends CrudRepository<User, Long> {
    //
    User findByUsername(String username);
}
