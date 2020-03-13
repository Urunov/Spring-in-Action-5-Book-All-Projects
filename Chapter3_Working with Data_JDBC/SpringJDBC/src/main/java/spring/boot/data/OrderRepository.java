package spring.boot.data;

import spring.boot.Order;

/**
 * @Created 09 / 03 / 2020 - 5:20 PM
 * @project SpringData
 * @Author Hamdamboy
 */
public interface OrderRepository {
   Order save(Order order);
}
