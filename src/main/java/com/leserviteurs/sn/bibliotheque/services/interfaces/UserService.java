package com.leserviteurs.sn.bibliotheque.services.interfaces;

import java.util.List;

import com.leserviteurs.sn.bibliotheque.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> readAllUsers();

    UserDTO findById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteById(Long id);

    void deleteAllUsers();
}
