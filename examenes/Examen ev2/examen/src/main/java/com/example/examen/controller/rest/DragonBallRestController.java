package com.example.examen.controller.rest;

import com.example.examen.model.DragonBall;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dragonball")
public class DragonBallRestController {

    private List<DragonBall> dragonBalls = new ArrayList<>();

    // Endpoint para obtener la lista de Dragon Balls distribuidas por el mundo
    @GetMapping("/radar")
    public List<DragonBall> getListDragonBallsSpread() {
        // Lógica para obtener la lista de Dragon Balls distribuidas
        return dragonBalls;
    }

    // Endpoint para obtener la lista de Dragon Balls que poseo
    @GetMapping("/owned")
    public List<DragonBall> getListDragonBallsOwn() {
        // Lógica para obtener la lista de Dragon Balls que poseo
        return dragonBalls;
    }

    // Endpoint para obtener una Dragon Ball con cierta cantidad de stardots
    @GetMapping("/get")
    public DragonBall getDragonBallByStardots(@RequestParam int ballNumber) {
        // Lógica para buscar y devolver la Dragon Ball con la cantidad de stardots especificada
        for (DragonBall ball : dragonBalls) {
            if (ball.getStarDots() == ballNumber) {
                return ball;
            }
        }
        return null; // Si no se encuentra ninguna Dragon Ball con la cantidad de stardots especificada
    }

    // Endpoint para invocar a Shenron
    @PostMapping("/invokeDragon")
    public String invokeShenron() {
        // Lógica para invocar a Shenron y cumplir el deseo
        if (dragonBalls.size() == 7) {
            dragonBalls.clear(); // Una vez invocado Shenron, las bolas de dragón vuelven a esparcirse por el mundo
            return "¡El deseo ha sido concedido por Shenron!";
        } else {
            return "No posees todas las 7 bolas de dragón para invocar a Shenron.";
        }
    }
}
