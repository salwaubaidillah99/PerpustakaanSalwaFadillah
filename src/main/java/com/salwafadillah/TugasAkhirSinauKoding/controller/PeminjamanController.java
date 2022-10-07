package com.salwafadillah.TugasAkhirSinauKoding.controller;

import com.salwafadillah.TugasAkhirSinauKoding.common.Response;
import com.salwafadillah.TugasAkhirSinauKoding.entity.dto.PeminjamanDTO;
import com.salwafadillah.TugasAkhirSinauKoding.service.Impl.PeminjamanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peminjamans")

public class PeminjamanController {
    @Autowired
    private PeminjamanServiceImpl service;

    @GetMapping("/find-all")
    public Response findAllData() {
        List<PeminjamanDTO> data = service.findAllData();
        return new Response(data,"Get All Data Peminjaman", HttpStatus.OK) ;
    }

    @PostMapping("/create")
    public Response saveData(@RequestBody PeminjamanDTO param) {

        if (service.save(param) == null) {
            return new Response("Data Peminjaman Tidak Ditemukan", HttpStatus.BAD_GATEWAY);
        }
        return new Response(service.save(param),"Data Berhasil Di Tambahkan", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateData(@PathVariable Long id,
                                       @RequestBody PeminjamanDTO param){
        PeminjamanDTO data = service.update(param, id);

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

    @DeleteMapping("/delete/{id}")
    public Response deleteData(@PathVariable Long id) {
        if (service.delete(id)) {
            return new Response("Data Berhasil di Hapus", HttpStatus.OK);
        } else {
            return new Response("Data Gagal di Hapus", HttpStatus.BAD_REQUEST);
        }
    }

}
