package com.salwafadillah.TugasAkhirSinauKoding.service.Impl;

import com.salwafadillah.TugasAkhirSinauKoding.entity.Anggota;
import com.salwafadillah.TugasAkhirSinauKoding.entity.Petugas;
import com.salwafadillah.TugasAkhirSinauKoding.entity.User;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.AnggotaDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.PetugasDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.AnggotaMapping;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.PetugasMapping;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.UserMapping;
import com.salwafadillah.TugasAkhirSinauKoding.repository.PetugasRepository;
import com.salwafadillah.TugasAkhirSinauKoding.repository.UserRepository;
import com.salwafadillah.TugasAkhirSinauKoding.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetugasServiceImpl implements PetugasService {
    @Autowired
    private PetugasRepository repository;

    @Autowired
    UserRepository userRepository;

    public PetugasDTO save(PetugasDTO param) {
        User user = UserMapping.instance.toEntity(param.getUser());

        Petugas data = PetugasMapping.instance.toEntity(param);

        if (param.getUser() !=null){
            user = userRepository.save(user);

            data.getUser().setId(user.getId());
        }
        data=repository.save(data);

        return PetugasMapping.instance.toDto(data);
    }

    @Override
    public List<PetugasDTO> findAllData()
    {
        return PetugasMapping.instance.toListDto(repository.findAll());
    }
    @Override
    public PetugasDTO update(PetugasDTO param, Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNamaPetugas(param.getNamaPetugas()== null ? data.getNamaPetugas() : param.getNamaPetugas());
            data.setNoTelp(param.getNoTelp()== null ? data.getNoTelp() : param.getNoTelp());
            data.setAlamat(param.getAlamat()== null ? data.getAlamat() : param.getAlamat());

            return PetugasMapping.instance.toDto(repository.save(data));
        }

        return PetugasMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PetugasDTO findById(Long id) {
        return PetugasMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}