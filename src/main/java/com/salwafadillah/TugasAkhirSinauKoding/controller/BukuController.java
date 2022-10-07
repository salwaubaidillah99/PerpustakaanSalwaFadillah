package com.salwafadillah.TugasAkhirSinauKoding.controller;

import com.salwafadillah.TugasAkhirSinauKoding.entity.Buku;
import com.salwafadillah.TugasAkhirSinauKoding.entity.Peminjaman;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.BukuDTO;
import com.salwafadillah.TugasAkhirSinauKoding.repository.BukuRepository;
import com.salwafadillah.TugasAkhirSinauKoding.repository.PeminjamanRepository;
import com.salwafadillah.TugasAkhirSinauKoding.service.Impl.BukuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bukus")

public class BukuController {
    @Autowired
    private BukuServiceImpl service;

    @GetMapping("/find-all")
    public ResponseEntity<?>findAllData(){
        return new ResponseEntity<>(service.findAllData(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?>saveData(@RequestBody BukuDTO param){
        return new ResponseEntity<>(service.save(param),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateData(@PathVariable Long id,
                                       @RequestBody BukuDTO param){
        BukuDTO data = service.update(param, id);

        if (data != null){
            return  new ResponseEntity<>(data, HttpStatus.OK);
        }
        else
        {
            return  new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        return  new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?>deleteData(@PathVariable Long id){
        if (service.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

}



