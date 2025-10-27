package com.leserviteurs.sn.bibliotheque.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private long id;
    private String nomUtiliseur;
    private String email;
    private String NumeroTelephone;
}
