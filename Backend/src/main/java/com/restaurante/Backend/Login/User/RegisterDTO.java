package com.restaurante.Backend.Login.User;

import com.restaurante.Backend.Admin.roles.UserRole;

public record RegisterDTO (String login , String password , UserRole role ){
}
