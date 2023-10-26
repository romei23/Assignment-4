package com.csc340.jpacrudassignment.cat;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Ro Mei
 */
public interface CatRepository extends JpaRepository<Cat, Long> {

    public List<Cat> findByName(String name);

    @Query("SELECT c FROM Cat c WHERE CONCAT(c.name, c.breed) LIKE %?1%")
    public List<Cat> search(String keyword);
}
