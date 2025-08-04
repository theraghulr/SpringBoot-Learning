package com.springboot.learning.SpringBoot.Repository;

import com.springboot.learning.SpringBoot.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TodoRepository extends JpaRepository<Todo,Long> {

}
