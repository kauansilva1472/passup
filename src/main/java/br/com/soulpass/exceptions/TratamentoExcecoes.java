
package br.com.soulpass.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class TratamentoExcecoes {

    // Erros do banco Oracle
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> erroBanco(SQLException erro) {

        // Registro duplicado
        if (erro.getErrorCode() == 1) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro: registro ja cadastrado no banco!");
        }

        // Valor maior que o permitido
        if (erro.getErrorCode() == 12899) {
            return ResponseEntity.badRequest()
                    .body("Erro: valor maior que o permitido no banco!");
        }

        // Erros de relacionamento
        if (erro.getErrorCode() == 2291 ||
                erro.getErrorCode() == 2292) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro: problema de relacionamento entre registros!");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao acessar o banco de dados!");
    }

    // Erros de valores invalidos
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> erroDados(IllegalArgumentException erro) {

        return ResponseEntity.badRequest()
                .body("Erro: dados invalidos!");
    }

    // Erros inesperados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> erroGeral(Exception erro) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno no servidor!");
    }
}
