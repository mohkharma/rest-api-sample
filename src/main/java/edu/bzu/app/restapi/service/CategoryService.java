package edu.bzu.app.restapi.service;

import edu.bzu.app.restapi.payLoad.CategoryDto;

import java.util.List;

/**
 * Why do we need interface in service layer?
 * Implementing an interface allows a class to become more formal about the behavior it promises to provide.
 * Interfaces form a contract between the class and the outside world,
 * and this contract is enforced at build time by the compiler.
 * In case you have multiple implementations you need to use qualifier annotation to specify kind of implementation you need to inject.
 * Or you can create object by yourself using class names
 */
public interface CategoryService {
    CategoryDto createCategory(CategoryDto CategoryDto);

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(long id);

    CategoryDto updateCategory(CategoryDto CategoryDto, long id);

    void deleteCategoryById(long id);
}
