package com.breamer.demoforjpa.dao.primary;

import com.breamer.demoforjpa.entity.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User表持久层
 * @author breamer
 * @date 2018/7/25 14:27
 */
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    /**
     * 根据ID查询
     * @author zhang.penghao
     * @date 2018/7/26 15:27
     * @param id ID
     * @return List
     */
    @Query(value = "select * from user where id = ?1", nativeQuery = true)
    List<User> listUserByID(Integer id);

    /**
     * 根据Name查询
     * @author zhang.penghao
     * @date 2018/7/26 15:27
     * @param name 名称
     * @return List
     */
    @Query(value = "select * from user where user_name = :name", nativeQuery = true)
    List<User> listUserByName(@Param("name") String name);
}
