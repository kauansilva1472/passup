
package br.com.soulpass.Bo;

import br.com.soulpass.dao.TransporteDao;
import br.com.soulpass.entities.Transporte;

import java.sql.SQLException;
import java.util.ArrayList;

public class TransporteBo {

    TransporteDao transporteDao;

    // Selecionar
    public ArrayList<Transporte> selecionarBo()
            throws SQLException, ClassNotFoundException {

        transporteDao = new TransporteDao();

        return transporteDao.selecionar();
    }

    // Inserir
    public String inserirBo(Transporte transporte)
            throws SQLException, ClassNotFoundException {

        TransporteDao transporteDao = new TransporteDao();

        return transporteDao.inserir(transporte);
    }

    // Atualizar
    public String atualizarBo(Transporte transporte)
            throws SQLException, ClassNotFoundException {

        TransporteDao transporteDao = new TransporteDao();

        return transporteDao.atualizar(transporte);
    }


    // Deletar
    public String deletarBo(int id)
            throws SQLException, ClassNotFoundException {

        TransporteDao transporteDao = new TransporteDao();

        return transporteDao.deletar(id);
    }


    // Buscar por ID
    public Transporte buscarPorIdBo(int id)
            throws SQLException, ClassNotFoundException {

        TransporteDao transporteDao = new TransporteDao();

        return transporteDao.buscarPorId(id);
    }


}

