package ru.levchenko.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.levchenko.forms.LoginForm;
import ru.levchenko.models.Token;
import ru.levchenko.models.User;
import ru.levchenko.models.dto.TokenDto;
import ru.levchenko.repositories.TokenRepository;
import ru.levchenko.repositories.UsersRepository;

import java.util.Optional;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userCandidate = usersRepository.findOneByLogin(loginForm.getLogin());
        if (userCandidate.isPresent()){

           User user = userCandidate.get();

           if (passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())){
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10,true,true))//рандомный токен из 10 символов
                        .build();
                tokenRepository.save(token);
                return TokenDto.from(token);
            }
            throw new IllegalArgumentException("Incorrect password");

        }
        throw new IllegalArgumentException("User not Found");
    }
}
