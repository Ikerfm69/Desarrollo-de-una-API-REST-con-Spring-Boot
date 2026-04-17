package com.iker.todorest.users;

public record NewUserCommand(
        String username, String email, String password
) {
}
