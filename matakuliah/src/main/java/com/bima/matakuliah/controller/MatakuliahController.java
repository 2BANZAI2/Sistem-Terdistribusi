/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bima.matakuliah.controller;

import com.bima.matakuliah.entity.Matakuliah;
import com.bima.matakuliah.service.MatakuliahService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("api/v1/matakuliah")
public class MatakuliahController {
    @Autowired
    private MatakuliahService matakuliahService;
    
    @GetMapping
    public List<Matakuliah> getAll(){
        return matakuliahService.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Matakuliah getMatakuliah(@PathVariable("id") Long id){
        return matakuliahService.getMahasiswa(id);
    }
    
    @PostMapping
    public void insert(@RequestBody Matakuliah matakuliah){
        matakuliahService.insert(matakuliah);
    }
    
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        matakuliahService.delete(id);
    }
    
    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id,
            @RequestParam(required = false) String kode,
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) Integer sks){
        matakuliahService.update(id, kode, nama, sks);
    }
    
}