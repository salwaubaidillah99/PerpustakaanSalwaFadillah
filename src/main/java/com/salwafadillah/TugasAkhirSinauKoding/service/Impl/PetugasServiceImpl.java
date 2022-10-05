package com.salwafadillah.TugasAkhirSinauKoding.service.Impl;

import com.salwafadillah.TugasAkhirSinauKoding.entity.Anggota;
import com.salwafadillah.TugasAkhirSinauKoding.entity.Pengembalian;
import com.salwafadillah.TugasAkhirSinauKoding.entity.Petugas;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.PengembalianDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.PetugasDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.PengembalianMapping;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.PetugasMapping;
import com.salwafadillah.TugasAkhirSinauKoding.repository.AnggotaRepository;
import com.salwafadillah.TugasAkhirSinauKoding.repository.PengembalianRepository;
import com.salwafadillah.TugasAkhirSinauKoding.repository.PetugasRepository;
import com.salwafadillah.TugasAkhirSinauKoding.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetugasServiceImpl implements PetugasService {
    @Autowired
    private PetugasRepository repository;

    @Override
    public PetugasDTO save(PetugasDTO param) {
        Petugas data = repository.save(PetugasMapping.instance.toEntity(param));
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