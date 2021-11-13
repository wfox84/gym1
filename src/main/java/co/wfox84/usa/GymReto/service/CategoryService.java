/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.service;

import co.wfox84.usa.GymReto.model.Category;
import co.wfox84.usa.GymReto.model.Reservation;
import co.wfox84.usa.GymReto.reports.CounterClient;
import co.wfox84.usa.GymReto.repository.CategoryRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author masterKomodoro
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
        
    public Optional<Category> getCategory(int id){
            return categoryRepository.getCategory(id);
    }
   
    public Category save(Category  category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> ct=categoryRepository.getCategory(category.getId());
            if(ct.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            
            }
        
        }
    
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> g = categoryRepository.getCategory(category.getId());
            if (!g.isEmpty()) {
                if (category.getDescription() != null) {
                    g.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    g.get().setName(category.getName());
                }
                categoryRepository.save(g.get());
                return g.get();
            } else {
                return category;
            }
        }else{
            return category;
        }
    }

    public boolean deleteCategory(int id){
        Boolean aBoolean =getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    
}
