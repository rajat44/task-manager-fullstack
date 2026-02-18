package com.rajat.taskmanager.service;

import com.rajat.taskmanager.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    TaskResponse create(TaskRequest request);

    TaskResponse update(Long id, TaskRequest request);

    void delete(Long id);

    TaskResponse getById(Long id);

    Page<TaskResponse> getAll(Pageable pageable);
}
