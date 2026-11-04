
package br.com.soulpass.controller;

import br.com.soulpass.Bo.TransporteBo;
import br.com.soulpass.entities.Transporte;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/transportes")
public class TransporteController {

    TransporteBo transporteBo = new TransporteBo();

    // Selecionar
    @GetMapping
    public ArrayList<Transporte> selecionarRs()
            throws SQLException, ClassNotFoundException {

        return transporteBo.selecionarBo();
    }

    // Inserir
    @PostMapping
    public String inserirRs(@RequestBody Transporte transporte)
            throws SQLException, ClassNotFoundException {

        return transporteBo.inserirBo(transporte);
    }

    // Atualizar
    @PutMapping
    public String atualizarRs(@RequestBody Transporte transporte)
            throws SQLException, ClassNotFoundException {

        return transporteBo.atualizarBo(transporte);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public String deletarRs(@PathVariable("id") int id)
            throws SQLException, ClassNotFoundException {

        return transporteBo.deletarBo(id);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Transporte> buscarPorIdRs(@PathVariable int id)
            throws SQLException, ClassNotFoundException {

        Transporte transporte = transporteBo.buscarPorIdBo(id);

        if (transporte == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transporte);
    }


}
