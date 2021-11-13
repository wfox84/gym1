/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.repository;

import co.wfox84.usa.GymReto.model.Category;
import co.wfox84.usa.GymReto.model.Reservation;
import co.wfox84.usa.GymReto.repository.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author masterKomodoro
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        
        return (List<Category>) categoryCrudRepository.findAll();
    
    }
    public Optional<Category> getCategory(int id){
    
        return categoryCrudRepository.findById(id);
    
    }
    
    public Category save(Category ca){
    
        return categoryCrudRepository.save(ca);
    }
    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }
    
}
