package com.example.demo.entityDTO;

import lombok.Data;

@Data
public class UserDTO {
    private long id;

    private String login;

    private Boolean isDemandeur;

    private Boolean isValidator;

    private Boolean isBenevole;

}
