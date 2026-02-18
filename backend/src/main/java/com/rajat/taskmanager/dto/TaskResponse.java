package com.rajat.taskmanager.dto;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        boolean isCompleted,
        LocalDateTime dueDate
) {}
