package com.salwafadillah.TugasAkhirSinauKoding.service;

import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.PetugasDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.UserDTO;

import java.util.List;

public interface UserService  {
    UserDTO save(UserDTO param);

    List<UserDTO> findAllData();

    UserDTO update (UserDTO param, Long id);

    Boolean delete(Long id);

    UserDTO findById(Long id);
}
