package com.iremnazyolcu.data.repository;

import com.iremnazyolcu.business.dto.ToDoDto;
import com.iremnazyolcu.data.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// ToDoRepository will be able to perform CRUD operations on the Entity specified in place of entityName.
// JpaRepository<entityName, primaryKeyType>
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
    List<ToDoEntity> findAllByCompleted(boolean completed);
}
