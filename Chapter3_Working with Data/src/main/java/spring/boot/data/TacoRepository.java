package spring.boot.data;

import spring.boot.Taco;

/**
 * @Created 09 / 03 / 2020 - 5:21 PM
 * @project SpringData
 * @Author Hamdamboy
 */
public interface TacoRepository {

    Taco save(Taco design);
}
