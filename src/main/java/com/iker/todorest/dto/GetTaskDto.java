package com.iker.todorest.dto;

import com.iker.todorest.model.Task;
import com.iker.todorest.users.NewUserResponse;

import java.time.LocalDateTime;

public record GetTaskDto(
        Long id,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime deadLine,
        NewUserResponse author
) {

    public static GetTaskDto of(Task t){
        return new GetTaskDto(
                t.getId(),
                t.getTitle(),
                t.getDescription(),
                t.getCreatedAt(),
                t.getDeadLine(),
                NewUserResponse.of(t.getAuthor())
        );
    }

}
