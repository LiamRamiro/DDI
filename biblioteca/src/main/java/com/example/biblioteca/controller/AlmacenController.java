package com.example.biblioteca.controller;

import com.example.biblioteca.model.AlmacenNew;
import com.example.biblioteca.model.AlmacenOld;
import com.example.biblioteca.service.AlmacenNewService;
import com.example.biblioteca.service.AlmacenOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AlmacenController {

    @Autowired
    AlmacenOldService almacenOldService;

    @Autowired
    AlmacenNewService almacenNewService;

    @RequestMapping("/formAlmacen")
    public String formAlmacen(Model model) {
        model.addAttribute("nuevoAlmacen", new AlmacenNew());
        return "formAlmacen";
    }

    @RequestMapping("/insertAlmacen")
    public String insertAlmacen(@ModelAttribute("nuevoAlmacen") AlmacenNew almacenNew, BindingResult result, Model model, @RequestParam(name = "nueva", required = false, defaultValue = "false") boolean nueva) {
        if (nueva) {
            model.addAttribute("almacenesNuevos", almacenNewService.insertAlmacenNew(almacenNew));
            model.addAttribute("almacenesViejos", almacenOldService.listarTodosAlmacenOld());
        } else {
            AlmacenOld almacenOld = new AlmacenOld();
            almacenOld.setId(almacenNew.getId());
            almacenOld.setNombre(almacenNew.getNombre());
            model.addAttribute("almacenesViejos", almacenOldService.insertAlmacenOld(almacenOld));
            model.addAttribute("almacenesNuevos", almacenNewService.listarTodosAlmacenNew());
        }
        return "finalmacen";
    }

    @RequestMapping("/deleteAlmacen")
    public String borrarAlmacen(@RequestParam(name = "newId", required = false) Integer newId,
                                @RequestParam(name = "newNombre", required = false) String newNombre,
                                @RequestParam(name = "oldId", required = false) Integer oldId,
                                @RequestParam(name = "oldNombre", required = false) String oldNombre,
                                Model model) {
        if (newId != null && newNombre != null) {
            almacenNewService.deleteAlmacenNew(newId, newNombre);
        }

        if (oldId != null && oldNombre != null) {
            almacenOldService.deleteAlmacenOld(oldId, oldNombre);
        }

        // Actualizamos las listas después de borrar
        model.addAttribute("almacenesNuevos", almacenNewService.listarTodosAlmacenNew());
        model.addAttribute("almacenesViejos", almacenOldService.listarTodosAlmacenOld());

        return "finalmacen";
    }

    @RequestMapping("/updateAlmacen/{id}")
    public String actualizarAlmacen(@PathVariable Integer id, Model model) {
        AlmacenNew almacenNew = almacenNewService.updateAlmacenNewList(id);
        AlmacenOld almacenOld = almacenOldService.updateAlmacenOldList(id);
        model.addAttribute("almacenesNuevos", almacenNew);
        model.addAttribute("almacenesViejos", almacenOld);
        return "finalmacen";
    }

    @RequestMapping("/searchAlmacen")
    public String buscarAlmacen(@RequestParam("search") String userInput, Model model) {
        List<AlmacenNew> lista = almacenNewService.searchAlmacenNew(userInput);
        List<AlmacenOld> lista2 = almacenOldService.searchAlmacenOld(userInput);
        model.addAttribute("almacenesNuevos", lista);
        model.addAttribute("almacenesViejos", lista2);
        return "finalmacen";
    }



}

