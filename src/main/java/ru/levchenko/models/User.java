package ru.levchenko.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.Pattern;


/**
 * User pojo mapping via Hibernate
 * for validate login,password and email use bean validation
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "hashPassword", nullable = false)
    private String hashPassword;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "uploadphoto")
    private String uploadPhoto;//путь к аватару юзера(скинуть в отдельную СУБД все файлы)
    @Column(nullable = false)
    private String email;
    @Column
    private String activationCode;
    @Column
    private boolean activated;


    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;


    public boolean isAdmin(){
        if (getRole().name().equals(Role.ADMIN.name())){
            return true;
        }
        return false;
    }


}
