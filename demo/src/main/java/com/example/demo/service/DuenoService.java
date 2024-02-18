package com.example.demo.service;

import com.example.demo.model.Dueno;
import com.example.demo.repository.DuenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenoService {

    @Autowired
    DuenoRepository duenoRepo;

    public List<Dueno> insertDueno(Dueno dueno){
        System.out.println("name:" + dueno.getNombre() + " dni:" + dueno.getDni());
        if(dueno.getId() == null){
            duenoRepo.insert(dueno);
        }else{
            //si existe un update
            duenoRepo.update(dueno);
        }
        //creamos una lista de dueños que gracias al DuenoRowMapper nos dara la estructura
        List<Dueno> lista = duenoRepo.findAll();
        for(Dueno dun : lista){
            System.out.println(dun.getNombre()+","+dun.getDni());
        }
        return lista;
    }

    public Dueno updateDuenoList(Integer id){
        Dueno dun = duenoRepo.findById(id);

        System.out.print(dun.getNombre()+","+dun.getDni());
        return dun;
    }

    public List<Dueno> deleteStudent(Integer id){
        duenoRepo.delete(id);

        List<Dueno> lista = duenoRepo.findAll();
        return lista;


    }

    public List<Dueno> searchDueno(String userInput){
        List<Dueno> lista = duenoRepo.searchByNombreOrApellido(userInput);

        for(Dueno dun : lista){
            System.out.println(dun.getNombre()+","+dun.getDni());

        }
        return lista;
    }

    public Dueno searchDuenoById(long id){
        return duenoRepo.findById(id);
    }


}
