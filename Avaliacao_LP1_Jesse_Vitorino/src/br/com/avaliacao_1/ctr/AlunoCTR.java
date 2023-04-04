/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_1.ctr;

import br.com.avaliacao_1.dao.AlunoDAO;
import br.com.avaliacao_1.dao.ConexaoDAO;
import br.com.avaliacao_1.dto.AlunoDTO;
import java.sql.ResultSet;

/**
 *
 * @author izbel
 */
public class AlunoCTR {

    AlunoDAO alunoDAO = new AlunoDAO();
    //*Metodo utilizado para controlar o acesso  ao metodo inserirAluno da classe AlunoDAO
    /**clssse AlunoDAO
     * 
     * @param alunoDTO,que vem da classe da pagina (VIEWW)
     * @return 
     */

    public String inserirAluno(AlunoDTO alunoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (tru ou false) 
            if (alunoDAO.inserirAluno(alunoDTO)) {
                return "Aluno Cadastrado com Sucessi!!!";
            } else {
                return "Aluno Não Cadastrado !!";
            }

        } ////Caso tenha algun erro no codigo acima é enviado uma menssagem no
         //Console com o  que esta acontecendo
        catch (Exception e) {
            System.out.println(e.getMessage());
            return " Aluno Não Cadastrados ";
        }

    }
    public ResultSet consultarAluno(AlunoDTO alunoDTO, int opcao) {
        ResultSet rs = null;
        rs = alunoDAO.consultarAluno(alunoDTO, opcao);
        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

    public Object excluirAluno(AlunoDTO alunoDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}//fecha o metodo inserir aluno
