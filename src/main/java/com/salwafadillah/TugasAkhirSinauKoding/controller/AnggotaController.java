package com.salwafadillah.TugasAkhirSinauKoding.controller;

import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.AnggotaDTO;
import com.salwafadillah.TugasAkhirSinauKoding.service.Impl.AnggotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.salwafadillah.TugasAkhirSinauKoding.common.Response;
import java.util.List;

@RestController
@RequestMapping("/anggotas")

public class AnggotaController {
    @Autowired
    private AnggotaServiceImpl service;

    @GetMapping("/find-all")
    public Response findAllData() {
        List<AnggotaDTO> data = service.findAllData();
        return new Response(data,"Get All Data Anggota", HttpStatus.OK) ;
    }

    @PostMapping("/create")
    public Response saveData(@RequestBody AnggotaDTO param) {

        if (service.save(param) == null) {
            return new Response("Data Anggota Tidak Ditemukan", HttpStatus.BAD_GATEWAY);
        }
        return new Response(service.save(param),"Data Berhasil Di Tambahkan", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateData(@PathVariable Long id,
                                       @RequestBody AnggotaDTO param){
        AnggotaDTO data = service.update(param, id);

        if (data != null){
            return  new ResponseEntity<>(data, HttpStatus.OK);
        }
        else
        {
            return  new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    public Response findById(@PathVariable Long id){
        return new Response(service.findById(id), "Berhasil Mengabil Data dari id " + id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteData(@PathVariable Long id) {
        if (service.delete(id)) {
            return new Response("Data Berhasil di Hapus", HttpStatus.OK);
        } else {
            return new Response("Data Gagal di Hapus", HttpStatus.BAD_REQUEST);
        }
    }
}