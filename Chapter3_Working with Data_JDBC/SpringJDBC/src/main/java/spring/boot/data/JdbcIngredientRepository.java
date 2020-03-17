package spring.boot.data;

/**
 * @Created 09 / 03 / 2020 - 5:20 PM
 * @project SpringData
 * @Author Hamdamboy
 */

// tag::classShell[]
//end::classShell[]
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring.boot.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
//tag::classShell[]

@Repository
public class JdbcIngredientRepository implements IngredientRepository{
    //
    //tag::jdbcTemplate[]
    private JdbcTemplate jdbcTemplate;

    //end::jdbcTemplate[]
    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbcTemplate = jdbc;
    }
    // end::classShell[]

    //tag::classShell

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from ingredient", this::mapRowToIngredient);
    }

    //tag::findOne[]

    @Override
    public Ingredient findById(String id) {
        return jdbcTemplate.queryForObject("select id, name, type from ingredient where id=?", this::mapRowToIngredient, id );
    }
    //tag::preJava8RowMapper[]
   /* @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject(
                "select id, name, type from Ingredient where id=?",
                new RowMapper<Ingredient>() {
                    public Ingredient mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        return new Ingredient(
                                rs.getString("id"),
                                rs.getString("name"),
                                Ingredient.Type.valueOf(rs.getString("type")));
                    };
                }, id);
    }
    //end::preJava8RowMapper[]
   */
    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into ingredient(id, name, type) values ( ?, ?, ? )," +
                      ingredient.getId(), ingredient.getName(), ingredient.getType().toString());

        return ingredient;
    }

   // Map Row to Ingredient  
    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException{

        Ingredient ingredient = new Ingredient(rs.getInt("id"), rs.getString("name"), Ingredient.Type.valueOf(rs.getString("type")));

        return ingredient;
    }
}