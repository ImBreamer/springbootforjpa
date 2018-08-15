package com.breamer.demoforjpa.dao.secondary;

import com.breamer.demoforjpa.entity.secondary.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author breamer
 * @Description:
 * @date 2018/7/25 14:27
 */
@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
}
