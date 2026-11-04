
package br.com.soulpass.controller;

import br.com.soulpass.Bo.UsuarioBo;
import br.com.soulpass.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    UsuarioBo usuarioBo = new UsuarioBo();

    // Selecionar
    @GetMapping
    public ArrayList<Usuario> selecionarRs() throws SQLException, ClassNotFoundException {
        return usuarioBo.selecionarBo();
    }

    // Inserir
    @PostMapping
    public ResponseEntity<Void> inserirRs(@RequestBody Usuario usuario)
            throws SQLException, ClassNotFoundException {

        usuarioBo.inserirBo(usuario);

        URI location = URI.create("/usuarios/" + usuario.getIdUsuario());
        return ResponseEntity.created(location).build();
    }

    // Atualizar
    @PutMapping
    public ResponseEntity<Void> atualizarRs(@RequestBody Usuario usuario)
            throws SQLException, ClassNotFoundException {

        usuarioBo.atualizarBo(usuario);
        return ResponseEntity.ok().build();
    }

    // Deletar
    @DeleteMapping
    public ResponseEntity<Void> deletarRs(@RequestBody Usuario usuario)
            throws SQLException, ClassNotFoundException {

        usuarioBo.deletarBo(usuario);
        return ResponseEntity.ok().build();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorIdRs(@PathVariable("id") int id)
            throws SQLException, ClassNotFoundException {

        Usuario usuario = usuarioBo.buscarPorIdBo(id);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

}

