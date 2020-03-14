package spring.jdbc.dao;

import spring.jdbc.model.FamilyMember;

import java.util.List;

/**
 * @Created 14 / 03 / 2020 - 9:47 PM
 * @project SpringJDBC
 * @Author Hamdamboy
 */
public interface FamilyDao {
    //
    int add(FamilyMember member);

    int update(FamilyMember member);

    List<FamilyMember> findAll();

    List<FamilyMember> findByName(String name);

    String getNameById(Long id);
}
