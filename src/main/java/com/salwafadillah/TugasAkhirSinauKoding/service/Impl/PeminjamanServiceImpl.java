package com.salwafadillah.TugasAkhirSinauKoding.service.Impl;

import com.salwafadillah.TugasAkhirSinauKoding.entity.Peminjaman;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.PeminjamanDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.PeminjamanMapping;
import com.salwafadillah.TugasAkhirSinauKoding.repository.PeminjamanRepository;
import com.salwafadillah.TugasAkhirSinauKoding.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    private PeminjamanRepository repository;

    @Override
    public PeminjamanDTO save(PeminjamanDTO param) {
        Peminjaman data = repository.save(PeminjamanMapping.instance.toEntity(param));
        return PeminjamanMapping.instance.toDto(data);
    }

    @Override
    public List<PeminjamanDTO> findAllData()
    {
        return PeminjamanMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public PeminjamanDTO update(PeminjamanDTO param, Long id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setTglPinjam(param.getTglPinjam() == null ? data.getTglPinjam() : param.getTglPinjam());
            data.setTglKembali(param.getTglKembali() != null ? param.getTglKembali() : data.getTglKembali());

            return PeminjamanMapping.instance.toDto(repository.save(data));
        }

        return PeminjamanMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PeminjamanDTO findById(Long id) {
        return PeminjamanMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
