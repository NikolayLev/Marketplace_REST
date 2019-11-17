package ru.levchenko.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.levchenko.models.Token;

@Data
@AllArgsConstructor
public class TokenDto {
    private String value;

    public static TokenDto from(Token token){
        return new TokenDto(token.getValue());
    }
}
