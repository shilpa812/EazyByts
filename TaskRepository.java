package com.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRM.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
