package com.salwafadillah.TugasAkhirSinauKoding.service.Impl;

import com.salwafadillah.TugasAkhirSinauKoding.entity.Peminjaman;
import com.salwafadillah.TugasAkhirSinauKoding.entity.Pengarang;
import com.salwafadillah.TugasAkhirSinauKoding.entity.Pengembalian;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.PengarangDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.PengembalianDTO;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.PengarangMapping;
import com.salwafadillah.TugasAkhirSinauKoding.entity.mapping.PengembalianMapping;
import com.salwafadillah.TugasAkhirSinauKoding.repository.PeminjamanRepository;
import com.salwafadillah.TugasAkhirSinauKoding.repository.PengarangRepository;
import com.salwafadillah.TugasAkhirSinauKoding.repository.PengembalianRepository;
import com.salwafadillah.TugasAkhirSinauKoding.service.PeminjamanService;
import com.salwafadillah.TugasAkhirSinauKoding.service.PengembalianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengembalianServiceImpl implements PengembalianService {
    @Autowired
    private PengembalianRepository repository;

    @Override
    public PengembalianDTO save(PengembalianDTO param) {
        Pengembalian data = repository.save(PengembalianMapping.instance.toEntity(param));
        return PengembalianMapping.instance.toDto(data);
    }

    @Override
    public List<PengembalianDTO> findAllData()
    {
        return PengembalianMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public PengembalianDTO update(PengembalianDTO param, Long id) {
        Pengembalian data = repository.findById(id).orElse(null);
        if (data != null){
            data.setTglPengembalian(param.getTglPengembalian()== null ? data.getTglPengembalian() : param.getTglPengembalian());
            data.setDenda(param.getDenda()== null ? data.getDenda() : param.getDenda());

            return PengembalianMapping.instance.toDto(repository.save(data));
        }

        return PengembalianMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Pengembalian data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PengembalianDTO findById(Long id) {
        return PengembalianMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}