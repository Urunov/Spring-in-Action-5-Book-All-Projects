package spring.security.data;

import org.springframework.data.repository.CrudRepository;
import spring.security.Taco;

/**
 * @Created 17 / 03 / 2020 - 6:46 PM
 * @project BootSecure
 * @Author Hamdamboy
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
