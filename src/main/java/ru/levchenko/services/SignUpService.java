package ru.levchenko.services;

import ru.levchenko.forms.UserForm;
import ru.levchenko.models.User;


import java.util.Optional;

public interface SignUpService {
    boolean signUp(UserForm userForm);
    boolean signUp(User user);
    Optional<User> findByUserName(String userName);
    boolean activateUser(String code);
}
