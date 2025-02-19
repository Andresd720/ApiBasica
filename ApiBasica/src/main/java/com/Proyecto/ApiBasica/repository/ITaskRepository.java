package com.Proyecto.ApiBasica.repository;

import com.Proyecto.ApiBasica.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task,Long> {
}
