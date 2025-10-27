package com.leserviteurs.sn.bibliotheque.mapper;

import org.mapstruct.Mapper;

import com.leserviteurs.sn.bibliotheque.dto.UserDTO;
import com.leserviteurs.sn.bibliotheque.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
        UserDTO toUserDTO(User user);

        User toUser(UserDTO userDTO);
}
