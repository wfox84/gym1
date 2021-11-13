/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.web;

import co.wfox84.usa.GymReto.model.Category;
import co.wfox84.usa.GymReto.model.Client;
import co.wfox84.usa.GymReto.service.CategoryService;
import co.wfox84.usa.GymReto.service.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author masterKomodoro
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryService.getAll();    
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    
    }    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Category update (@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("{/id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean delete(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }
}
