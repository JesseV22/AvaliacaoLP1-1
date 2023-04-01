/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao_1.dto;

/**
 *
 * @author izbel
 */
public class AlunoDTO {
    private String nomeCli, prontuarioCli, turmaCli, rgCli;
    private int idCli;

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getProntuarioCli() {
        return prontuarioCli;
    }


 
    public String getCpfCli() {
        return turmaCli;
    }

    public void setCpfCli(String cpfCli) {
        this.turmaCli = cpfCli;
    }

    public String getRgCli() {
        return rgCli;
    }

    public void setRgCli(String rgCli) {
        this.rgCli = rgCli;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

}
