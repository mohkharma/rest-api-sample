package edu.bzu.app.restapi.repository;

import edu.bzu.app.restapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
