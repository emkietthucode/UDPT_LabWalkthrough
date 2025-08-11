package com.ctk.mongodb;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NhanVienController {
    @Autowired
    NhanVienRepository repo;

    @PostMapping("/nhanvien")
    public ResponseEntity<NhanVien> ThemNhanVien(@RequestBody NhanVien nhanvien) {
        try {
            NhanVien _nhanvien = repo.save(new NhanVien(nhanvien.getManv(), nhanvien.getHoten(),
                    nhanvien.getSoNamKinhNghiem(), nhanvien.isThuviec()));
            return new ResponseEntity<>(_nhanvien, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/nhanvien/{id}")
    public ResponseEntity<NhanVien> CapNhatNhanVien(@PathVariable("id") String id, @RequestBody NhanVien nhanvien) {
        Optional<NhanVien> nhanvienData = repo.findById(id);

        if (nhanvienData.isPresent()) {
            NhanVien _nhanvien = nhanvienData.get();
            _nhanvien.setHoten(nhanvien.getHoten());
            _nhanvien.setSoNamKinhNghiem(nhanvien.getSoNamKinhNghiem());
            _nhanvien.setThuviec(nhanvien.isThuviec());
            return new ResponseEntity<>(repo.save(_nhanvien), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/nhanvien/{id}")
    public ResponseEntity<HttpStatus> XoaMotNhanVien(@PathVariable("id") String id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/nhanvienall")
    public ResponseEntity<HttpStatus> XoaTatCaNhanVien() {
        try {
            repo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nhanvien")
    public ResponseEntity<List<NhanVien>> XemDanhSachNhanVien() {
        try {
            List<NhanVien> nhanvienlst = new ArrayList<NhanVien>();

            repo.findAll().forEach(nhanvienlst::add);

            if (nhanvienlst.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(nhanvienlst, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nhanvien/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable("id") String id) {
        Optional<NhanVien> nhanvienData = repo.findById(id);
        if (nhanvienData.isPresent()) {
            return new ResponseEntity<>(nhanvienData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}