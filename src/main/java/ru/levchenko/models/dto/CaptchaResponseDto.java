package ru.levchenko.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;

/**
 * Dto for google captcha
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CaptchaResponseDto {
    private boolean success;
    @JsonAlias("error-codes")
    private Set<String>  errorCodes;
}