package com.leserviteurs.sn.bibliotheque.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.leserviteurs.sn.bibliotheque.dto.UserDTO;
import com.leserviteurs.sn.bibliotheque.entity.User;
import com.leserviteurs.sn.bibliotheque.mapper.UserMapper;
import com.leserviteurs.sn.bibliotheque.repository.UserRepository;
import com.leserviteurs.sn.bibliotheque.services.interfaces.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        User saved = userRepository.save(user);
        return userMapper.toUserDTO(saved);
    }

    @Override
    public List<UserDTO> readAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'id : " + id));
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'id : " + id));

        if (userDTO.getNomUtiliseur() != null) user.setNomUtiliseur(userDTO.getNomUtiliseur());
        if (userDTO.getEmail() != null) user.setEmail(userDTO.getEmail());
        if (userDTO.getNumeroTelephone() != null) user.setNumeroTelephone(userDTO.getNumeroTelephone());

        User updated = userRepository.save(user);
        return userMapper.toUserDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
