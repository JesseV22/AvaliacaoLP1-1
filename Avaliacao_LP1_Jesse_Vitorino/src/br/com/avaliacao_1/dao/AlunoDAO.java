package br.com.avaliacao_1.dao;

import br.com.avaliacao_1.dto.AlunoDTO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Aluno
 */
public class AlunoDTO {

    public AlunoDTO() {

    }
    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirAluno(AlunoDTO cdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Insert into cliente (nome_cli, prontuario_cli, turma_cli, bairro_cli, "
                    + "cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli) values ( "
                    + "'" + cdto.getNomeCli() + "', "
                    + "'" + cdto.getProntuarioCli() + "', "
                    + cdto.getTurmaCli() + ", "
                    + "'" + cdto.getBairroCli() + "', "
                    + "'" + cdto.getCidadeCli() + "', "
                    + "'" + cdto.getEstadoCli() + "', "
                    + "'" + cdto.getCepCli() + "', "
                    + "'" + cdto.getCpfCli() + "', "
                    + "'" + cdto.getRgCli() + "');";
            //System.out.println(comando);
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean atualizarAluno(AlunoDTO cdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "update cliente set "
                    + "nome_cli = '" + cdto.getNomeCli() + "', "
                    + "prontuario_cli = '" + cdto.getProntuarioCli() + "', "
                    + "turma_cli = " + cdto.getTurmaCli() + ", "
                    + "bairro_cli = '" + cdto.getBairroCli() + "', "
                    + "cidade_cli = '" + cdto.getCidadeCli() + "', "
                    + "estado_cli = '" + cdto.getEstadoCli() + "', "
                    + "cep_cli = '" + cdto.getCepCli() + "', "
                    + "cpf_cli = '" + cdto.getCpfCli() + "', "
                    + "rg_cli = '" + cdto.getRgCli() + "' where id_cli = " + cdto.getIdCli();
            //System.out.println(comando);
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarAluno(AlunoDTO clienteDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "SELECT c.* "
                            + "FROM cliente c "
                            + "WHERE nome_cli LIKE '" + clienteDTO.getNomeCli() + "%' "
                            + "ORDER BY c.nome_cli";
                    break;
                case 2:
                    comando = "SELECT c.* "
                            + "FROM cliente c "
                            + "WHERE c.id_cli = " + clienteDTO.getIdCli();
                    break;
                case 3:
                    comando = "SELECT c.id_cli, c.nome_cli FROM cliente c ";
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
    public boolean excluirAluno(AlunoDTO cdto){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from cliente where id_cli = "
                    + cdto.getIdCli();
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
        finally {
            ConexaoDAO.CloseDB();
        }
    }
}
