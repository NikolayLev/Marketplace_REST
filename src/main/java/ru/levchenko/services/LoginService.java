package ru.levchenko.services;

import ru.levchenko.forms.LoginForm;
import ru.levchenko.models.dto.TokenDto;

public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
