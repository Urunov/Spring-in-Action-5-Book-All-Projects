package spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring.jdbc.model.FamilyMember;

import java.util.List;

/**
 * @Created 14 / 03 / 2020 - 9:34 PM
 * @project SpringJDBC
 * @Author Hamdamboy
 */
@Repository
public class FamilyRepository implements FamilyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int add(FamilyMember member) {
        return jdbcTemplate.update("insert  into family(id, firstname, lastname, age) values ( ?, ?, ?, ? )", member.getId(), member.getFirstname(), member.getLastname(),
                member.getAge());
    }

    @Override
    public int update(FamilyMember member) {
      return jdbcTemplate.update("update family set name = ? where id = ?" + member.getFirstname(), member.getId());
    }

    @Override
    public List<FamilyMember> findAll() {
        return jdbcTemplate.query("select * from family",
                (rs, rowNum) ->
                        new FamilyMember(
                                rs.getLong("id"),
                                rs.getString("firstname")));
    }

    @Override
    public List<FamilyMember> findByName(String name) {

        return jdbcTemplate.queryForObject("select * from family where id = ?, new Object[] {name}, " +
                "(rs, rowNum) -> Optinal.of(new FamilyMember(rs.getFirstname");
     }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject("select name from family where id = ?",
                new Object[]{id},
                String.class);
    }
}

