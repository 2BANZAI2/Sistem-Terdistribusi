/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bima.matakuliah.service;

import com.bima.matakuliah.entity.Matakuliah;
import com.bima.matakuliah.repository.MatakuliahRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class MatakuliahService {
    @Autowired
    private MatakuliahRepository matakuliahRepository;
    
    public List<Matakuliah> getAll(){
        return matakuliahRepository.findAll();
    }
    
    public void insert(Matakuliah matakuliah){
        Optional<Matakuliah> matakuliahOptional = matakuliahRepository.findMatakuliahByKode(matakuliah.getKode());
        
         if(matakuliahOptional.isPresent()){
            throw new IllegalStateException("Matakuliah Sudah Ada");
        }
        
        matakuliahRepository.save(matakuliah);
    }
    
    public void delete(Long id){
        boolean ada = matakuliahRepository.existsById(id);
        if (!ada) {
            throw new IllegalStateException("Matakuliah ini tidak ada");
        }
        matakuliahRepository.deleteById(id);
    }
    
     public Matakuliah getMahasiswa(Long id){
        Optional<Matakuliah> matakuliahOptional = matakuliahRepository.findById(id);
        return matakuliahOptional.get();
    }
   
    @Transactional
    public void update(Long id, String kode, String nama, Integer sks){
        Matakuliah matakuliah = matakuliahRepository.findById(id)
        .orElseThrow(()-> new IllegalStateException("Matakuliah tidak ada"));
        
        if (kode != null && kode.length()>0 && !Objects.equals(matakuliah.getKode(), kode)) {
            matakuliah.setKode(kode);
        }
        
        if (nama != null && nama.length()>0 && !Objects.equals(matakuliah.getNama(), nama)) {
            matakuliah.setNama(nama);
        }
        
        if (sks != null && !Objects.equals(matakuliah.getSks(), sks)) {
            matakuliah.setSks(sks);
        }
        
    }
}