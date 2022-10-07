package com.salwafadillah.TugasAkhirSinauKoding.service.Impl;

import com.salwafadillah.TugasAkhirSinauKoding.entity.Pengarang;
import com.salwafadillah.TugasAkhirSinauKoding.entity.User;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.PengarangDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.UserDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.PengarangMapping;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.UserMapping;
import com.salwafadillah.TugasAkhirSinauKoding.repository.PengarangRepository;
import com.salwafadillah.TugasAkhirSinauKoding.repository.UserRepository;
import com.salwafadillah.TugasAkhirSinauKoding.service.PengarangService;
import com.salwafadillah.TugasAkhirSinauKoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO save(UserDTO param) {
        User data = repository.save(UserMapping.instance.toEntity(param));
        return UserMapping.instance.toDto(data);
    }

    @Override
    public List<UserDTO> findAllData()
    {
        return UserMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public UserDTO update(UserDTO param, Long id) {
        User data = repository.findById(id).orElse(null);
        if (data != null){
            data.setUsername(param.getUsername()== null ? data.getUsername() : param.getUsername());
            data.setPassword(param.getPassword()== null ? data.getPassword() : param.getPassword());
            data.setEmail(param.getEmail()== null ? data.getEmail() : param.getEmail());
            data.setRole(param.getRole()== null ? data.getRole() : param.getRole());

            return UserMapping.instance.toDto(repository.save(data));
        }

        return UserMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        User data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public UserDTO findById(Long id) {
        return UserMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
