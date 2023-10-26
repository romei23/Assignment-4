package com.csc340.jpacrudassignment.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author csc340-f23
 */
@Controller
@RequestMapping("/cat")
public class CatController {

    @Autowired
    CatService catService;

    @GetMapping("/all")
    public String getAllCats(Model model) {
        model.addAttribute("catList",
                catService.getAllCats());
        return "cat/list-cats";
    }

    @GetMapping("/search")
    public String getCats(Model model, @Param("keyword") String keyword) {
        model.addAttribute("catList",
                catService.getAllCats(keyword));
        model.addAttribute("keyword", keyword);
        return "cat/list-cats";
    }

    @GetMapping("/id={catId}")
    public String getCat(@PathVariable long catId, Model model) {
        model.addAttribute("cat",
                catService.getCat(catId));
        return "cat/cat-detail";
    }

    @GetMapping("/delete/id={catId}")
    public String deleteCat(@PathVariable long catId, Model model) {
        catService.deleteCat(catId);
        return "redirect:/cat/all";
    }

    @PostMapping("/create")
    public String createCat(Cat cat) {

        catService.saveCat(cat);
        return "redirect:/cat/all";
    }

    @PostMapping("/update")
    public String upateCat(Cat cat) {
        catService.saveCat(cat);
        return "redirect:/cat/all";
    }

    @GetMapping("/new-cat")
    public String newCatForm(Model model) {
        return "cat/new-cat";
    }

    @GetMapping("/update/id={catId}")
    public String updateCatForm(@PathVariable long catId, Model model) {
        model.addAttribute("cat",
                catService.getCat(catId));
        return "cat/update-cat";
    }
}
