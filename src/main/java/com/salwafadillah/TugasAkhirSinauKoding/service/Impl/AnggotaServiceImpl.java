package com.salwafadillah.TugasAkhirSinauKoding.service.Impl;

import com.salwafadillah.TugasAkhirSinauKoding.entity.Anggota;
import com.salwafadillah.TugasAkhirSinauKoding.entity.User;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.AnggotaDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.AnggotaMapping;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.UserMapping;
import com.salwafadillah.TugasAkhirSinauKoding.repository.AnggotaRepository;
import com.salwafadillah.TugasAkhirSinauKoding.repository.UserRepository;
import com.salwafadillah.TugasAkhirSinauKoding.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnggotaServiceImpl implements AnggotaService {

    @Autowired
    private AnggotaRepository repository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public AnggotaDTO save(AnggotaDTO param) {
        User user = UserMapping.instance.toEntity(param.getUser());

        Anggota data = AnggotaMapping.instance.toEntity(param);

       if (param.getUser() !=null){
           user = userRepository.save(user);

           data.getUser().setId(user.getId());
       }
       data=repository.save(data);

       return AnggotaMapping.instance.toDto(data);
    }

    @Override
    public List<AnggotaDTO> findAllData()
    {
        return AnggotaMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public AnggotaDTO update(AnggotaDTO param, Long id) {
        Anggota data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNamaAnggota(param.getNamaAnggota() == null ? data.getNamaAnggota() : param.getNamaAnggota());
            data.setJenisKelamin(param.getJenisKelamin() != null ? param.getJenisKelamin() : data.getJenisKelamin());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());
            data.setNoTelp(param.getNoTelp() != null ? param.getNoTelp() : data.getNoTelp());

            return AnggotaMapping.instance.toDto(repository.save(data));
        }

        return AnggotaMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Anggota data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public AnggotaDTO findById(Long id) {
        return AnggotaMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
