package ru.pavel2107.arch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pavel2107.arch.domain.Category;
import ru.pavel2107.arch.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service){
        this.service = service;
    }

    @GetMapping( value = "/rest/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> CategoryList(){
        return  service.findAll();
    }

    @DeleteMapping( value = "/rest/categories")
    @ResponseStatus( value = HttpStatus.NO_CONTENT)
    public void delete(@RequestParam( value = "id") Long id){
        service.delete( id);
    }

    @GetMapping( value = "/rest/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Category get(@PathVariable( value = "id") Long id){
        Category Category = service.find( id);
        return Category;
    }

    @PutMapping( value = "/rest/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Category save(@RequestBody Category category){
        if( category.getId() == 0 && service.findByCode( category.getCode()) != null){
            throw new RuntimeException( "Category with code " + category.getCode() + " already exists");
        }

        Category newCategory = service.save( category);
        return newCategory;
    }
}
