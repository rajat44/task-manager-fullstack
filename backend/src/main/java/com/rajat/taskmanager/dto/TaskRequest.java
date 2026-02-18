package com.rajat.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public record TaskRequest(
        @NotBlank
        @Size(max = 100)
        String title,
        String description,
        Boolean isCompleted,
        LocalDateTime dueDate
) {}
