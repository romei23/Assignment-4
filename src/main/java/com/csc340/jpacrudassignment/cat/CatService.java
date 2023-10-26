package com.csc340.jpacrudassignment.cat;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ro Mei
 */
@Service
public class CatService {

    @Autowired
    private CatRepository repo;

    /**
     * Get all cats.
     *
     * @return the list of cats.
     */
    public List<Cat> getAllCats() {
        return repo.findAll();
    }

    /**
     * Get all cats that match the keyword.
     *
     * @param keyword the search term.
     * @return the list of cats.
     */
    public List<Cat> getAllCats(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    /**
     * Get a single cat by ID
     *
     * @param catId
     * @return the product
     */
    public Cat getCat(long catId) {
        return repo.getReferenceById(catId);
    }

    /**
     * Delete a single cat by ID
     *
     * @param catId
     */
    public void deleteCat(long catId) {
        repo.deleteById(catId);
    }

    /**
     * Save a cat entry.
     *
     * @param cat
     */
    void saveCat(Cat cat) {
        repo.save(cat);
    }

}
