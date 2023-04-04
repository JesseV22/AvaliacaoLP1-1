package br.com.avaliacao_1.dao;

import br.com.avaliacao_1.dto.AlunoDTO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Aluno
 */
public class AlunoDAO {

    public AlunoDAO() {

    }
    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirAluno(AlunoDTO cdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Insert into aluno (nome_cli, prontuario_cli, turma_cli, curso_cli, "
                    + "estaluno_cli, data_cli, cpf_cli, rg_cli) values ( "
                    + "'" + cdto.getNomeCli() + "', "
                    + "'" + cdto.getProntuarioCli() + "', "
                    + cdto.getTurmaCli() + ", "
                    + "'" + cdto.getCursoCli() + "', "
                    + "'" + cdto.getEstalunoCli() + "', "
                    + "'" + cdto.getDataCli() + "', "
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
            String comando = "update aluno set "
                    + "nome_cli = '" + cdto.getNomeCli() + "', "
                    + "prontuario_cli = '" + cdto.getProntuarioCli() + "', "
                    + "turma_cli = " + cdto.getTurmaCli() + ", "
                    + "curso_cli = '" + cdto.getCursoCli() + "', "
                    + "estaluno_cli = '" + cdto.getEstalunoCli() + "', "
                    + "data_cli = '" + cdto.getDataCli() + "', "
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

    public ResultSet consultarAluno(AlunoDTO alunoDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "SELECT c.* "
                            + "FROM aluno c "
                            + "WHERE nome_cli LIKE '" + alunoDTO.getNomeCli() + "%' "
                            + "ORDER BY c.nome_cli";
                    break;
                case 2:
                    comando = "SELECT c.* "
                            + "FROM aluno c "
                            + "WHERE c.id_cli = " + alunoDTO.getIdCli();
                    break;
                case 3:
                    comando = "SELECT c.id_cli, c.nome_cli FROM aluno c ";
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public boolean excluirAluno(AlunoDTO cdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from aluno where id_cli = "
                    + cdto.getIdCli();
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fechar o statement
            stmt.close();
            return true;
        } /**Caso tenha algun erro no codigo acima é enviado uma mensagem no
         * console com o que esta acontecendo.
         */
        
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            ConexaoDAO.CloseDB();
        }
    }//Fecha o metodo  da classe  ConexãoDao para fechar o banco de dados
}//fechar classe AlunoDAO
