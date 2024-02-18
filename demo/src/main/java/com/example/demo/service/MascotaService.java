package com.example.demo.service;

import com.example.demo.model.Mascota;
import com.example.demo.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import com.example.demo.model.Mascota;
import com.example.demo.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MascotaService {

    @Autowired
    MascotaRepository mascRepo;

    public List<Mascota> insertMascota(Mascota mascota){
        System.out.println("name:" + mascota.getNombre() + " num_chip:" + mascota.getNum_chip() + " vacunado:" + mascota.getVacunado());
        if(mascota.getId() == null){
            mascRepo.insert(mascota);
        }else{
            //si existe un update
            mascRepo.update(mascota);
        }
        //creamos una lista de mascotas que gracias al MascotaRowMapper nos dara la estructura
        List<Mascota> lista = mascRepo.findAll();
        for(Mascota mas : lista){
            System.out.println(mas.getNombre()+","+mas.getNum_chip() + "," + mas.getVacunado());
        }
        return lista;
    }

    public Mascota updateMascotaList(Integer id){
        Mascota mas = mascRepo.findById(id);

        System.out.print(mas.getNombre()+","+mas.getNum_chip() + "," + mas.getVacunado());
        return mas;
    }

    public List<Mascota> deleteMascota(Integer id) {
        mascRepo.delete(id);

        List<Mascota> lista = mascRepo.findAll();
        return lista;

    }

    public List<Mascota> searchMascota(String userInput){
        List<Mascota> lista = mascRepo.searchByNombreOrApellido(userInput);

        for(Mascota mas : lista){
            System.out.println(mas.getNombre()+","+mas.getNum_chip() + "," + mas.getVacunado());

        }
        return lista;
    }

    public Mascota searchMascotaById(long id){

        return mascRepo.findById(id);
    }
}