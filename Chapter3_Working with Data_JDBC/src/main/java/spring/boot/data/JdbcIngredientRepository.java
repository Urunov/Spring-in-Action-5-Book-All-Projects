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
    private JdbcTemplate jdbc;

    //end::jdbcTemplate[]
    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    // end::classShell[]

    //tag::classShell

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from ingredient", this::mapRowToIngredient);
    }

    //tag::findOne[]

    @Override
    public Ingredient findById(String id) {
        return jdbc.queryForObject(
                "select id, name, type from ingredient where id=?", this::mapRowToIngredient, id );
    }
// end::findOne[]

    //end::finders[]

  /*
  //tag::preJava8RowMapper[]
  @Override
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

    //tag::save[]
    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update(
                "insert into Ingredient(id, name, type) values ( ?, ?, ? )," +
                        ingredient.getId(),
                        ingredient.getId(),
                        ingredient.getType().toString());
        return ingredient;
    }

    //end::save[]

    // tag::findOne[]
    //tag::finders[]
    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException{
        return new Ingredient(rs.getString("id"), rs.getString("name"), Ingredient.Type.valueOf(rs.getString("type")));
    }
    // end::finders[]
    //end::findOne[]

/*
//tag::classShell[]
  ...
//end::classShell[]
   */
//tag::classShell[]

}
//end::classShell[]