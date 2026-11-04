
package br.com.soulpass.Bo;

import br.com.soulpass.dao.UsuarioDao;
import br.com.soulpass.entities.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioBo {

    UsuarioDao usuarioDao;

    // Selecionar
    public ArrayList<Usuario> selecionarBo() throws SQLException, ClassNotFoundException {
        usuarioDao = new UsuarioDao();

        return usuarioDao.selecionar();
    }

    // Inserir
    public void inserirBo(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDao usuarioDao = new UsuarioDao();

        usuarioDao.inserir(usuario);
    }

    // Atualizar
    public void atualizarBo(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDao usuarioDao = new UsuarioDao();

        usuarioDao.atualizar(usuario);
    }

    // Deletar
    public void deletarBo(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDao usuarioDao = new UsuarioDao();

        usuarioDao.deletar(usuario);
    }


    // Buscar por ID
    public Usuario buscarPorIdBo(int id)
            throws SQLException, ClassNotFoundException {

        UsuarioDao usuarioDao = new UsuarioDao();

        return usuarioDao.buscarPorId(id);
    }

}

