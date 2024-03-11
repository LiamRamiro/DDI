package com.example.examen.controller.rest;

import com.example.examen.model.JanKenPon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jankenpon")
public class JanKenPonRestController {

    private List<JanKenPon> results = new ArrayList<>();

    @PostMapping("/play")
    public ResponseEntity<JanKenPon> playRound(@RequestParam String jugador1, @RequestParam String jugador2) {
        // Lógica para determinar el ganador y guardar el resultado
        String winner = determineWinner(jugador1, jugador2);
        JanKenPon roundResult = new JanKenPon(jugador1, jugador2, winner);
        results.add(roundResult);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roundResult);
    }

    @GetMapping("/results/{player}")
    public ResponseEntity<List<JanKenPon>> getPlayerResults(@PathVariable String player) {
        List<JanKenPon> playerResults = new ArrayList<>();
        for (JanKenPon result : results) {
            if (result.getPlayer().equalsIgnoreCase(player)) {
                playerResults.add(result);
            }
        }
        return ResponseEntity.ok(playerResults);
    }

    private String determineWinner(String player1, String player2) {
        if (player1.equals(player2)) {
            return "empate";
        } else if ((player1.equals("piedra") && player2.equals("tijeras")) ||
                (player1.equals("papel") && player2.equals("piedra")) ||
                (player1.equals("tijeras") && player2.equals("papel"))) {
            return "jugador1";
        } else {
            return "jugador2";
        }
    }

}