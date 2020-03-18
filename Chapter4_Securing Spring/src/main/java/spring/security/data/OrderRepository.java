package spring.security.data;

import org.springframework.data.repository.CrudRepository;
import spring.security.Order;

/**
 * @Created 17 / 03 / 2020 - 6:45 PM
 * @project BootSecure
 * @Author Hamdamboy
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
