package com.example.pokemon.controller;

import com.example.pokemon.model.Region;
import com.example.pokemon.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/regiones")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @RequestMapping("/lista")
    public String listadoRegiones(Model model) {
        List<Region> listaRegiones = regionRepository.getTodosRegion();
        model.addAttribute("listaRegiones", listaRegiones);
        return "listaRegiones";
    }

    @RequestMapping("/formModificar/{id}")
    public String formModificarRegion(@PathVariable Integer id, Model model) {
        Region region = regionRepository.getRegionPorId(id);
        if (region != null) {
            model.addAttribute("region", region);
            return "formModificarRegion";
        } else {
            return "paginaError";
        }
    }

    @RequestMapping("/formInsertar")
    public String formInsertarRegion(Model model) {
        Region region = new Region();
        model.addAttribute("region", region);
        return "formRegion";
    }

    @RequestMapping("/insertar")
    public String insertarNuevaRegion(@RequestParam Region region, Model model) {
        System.out.println(region.getId() + ", " + region.getNombre());
        regionRepository.crearRegion(region);
        return "redirect:/regiones/lista";
    }

    @RequestMapping("/actualizar")
    public String actualizarRegion(@RequestParam Region region, Model model) {
        System.out.println(region.getId() + ", " + region.getNombre());
        regionRepository.actualizarRegion(region);
        return "redirect:/regiones/lista";
    }

    @RequestMapping("/avisoEliminar/{id}")
    public String avisoEliminarRegion(@PathVariable Integer id, Model model) {
        Region region = regionRepository.getRegionPorId(id);
        if (region != null) {
            model.addAttribute("region", region);
            return "avisoEliminarRegion";
        } else {
            return "paginaError";
        }
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarRegion(@PathVariable Integer id, Model model) {
        Region region = regionRepository.getRegionPorId(id);
        if (region != null) {
            regionRepository.eliminarRegion(region);
            return "redirect:/regiones/lista";
        } else {
            return "paginaError";
        }
    }

    @ModelAttribute("regiones")
    public List<Region> getTodosRegiones() {
        return regionRepository.getTodosRegion();
    }

    @ModelAttribute("region")
    public Region getRegionPorId(@RequestParam(name = "id", required = false) Integer id) {
        if (id != null) {
            return regionRepository.getRegionPorId(id);
        } else {
            return new Region();
        }
    }
}
