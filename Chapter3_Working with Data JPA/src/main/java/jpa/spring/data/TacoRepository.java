package jpa.spring.data;

import jpa.spring.Taco;
import org.springframework.data.repository.CrudRepository;

/**
 * @Created 13 / 03 / 2020 - 5:03 PM
 * @project SpringJPA
 * @Author Hamdamboy
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {

}
