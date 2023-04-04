/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_1.ctr;

import br.com.avaliacao_1.dao.AlunoDAO;
import br.com.avaliacao_1.dto.AlunoDTO;

/**
 *
 * @author izbel
 */
public class AlunoCTR {

    AlunoDAO alunoeDAO = new AlunoDAO();
    //*Metodo utilizado para controlar o acesso  ao metodo inserirAluno da classe AlunoDAO

    public String inserirAluno(AlunoDTO alunoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (tru ou false) 
        if (alunoDAO.inserirAluno(alunoDTO)){
            return "Aluno Cadastrado com Sucessi!!!";
        }else { 
                return "Aluno Não Cadastrado !!";
        }

    }
    catch (Exception e){
    System.out.println(e.getMessage());
        return " Aluno Não Cadastrados ";
    }

}
