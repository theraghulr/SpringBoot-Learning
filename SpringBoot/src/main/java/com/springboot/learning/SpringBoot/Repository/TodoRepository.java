package com.springboot.learning.SpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TodoRepository extends JpaRepository<Todo,Long> {

}
