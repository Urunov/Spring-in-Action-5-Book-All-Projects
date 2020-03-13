package jpa.spring.data;

import jpa.spring.Order;

import org.springframework.data.repository.CrudRepository;

/**
 * @Created 13 / 03 / 2020 - 5:03 PM
 * @project SpringJPA
 * @Author Hamdamboy
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
