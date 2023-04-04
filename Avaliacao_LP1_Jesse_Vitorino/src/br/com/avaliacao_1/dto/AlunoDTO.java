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

    private String nomeCli, prontuarioCli, turmaCli, rgCli , cursoCli , cpfCli,dataCli,estalunoCli;
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
    public void setProntuarioCli(String prontuarioCli) {
        this.prontuarioCli = prontuarioCli;
    }

    public String getEstalunoCli() {
        return estalunoCli;
    }

    public void setEstalunoCli(String estalunoCli) {
        this.estalunoCli = estalunoCli;
    }

    public String getRgCli() {
        return rgCli;
    }

    public void setRgCli(String rgCli) {
        this.rgCli = rgCli;
    }

    public String getCursoCli() {
        return cursoCli;
    }

    public void setCursoCli(String cursoCli) {
        this.cursoCli = cursoCli;
    }
     public String getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(String cpfCli) {
        this.cursoCli = cpfCli;
    }

    public String getTurmaCli() {
        return turmaCli;
    }

    public void setTurmaCli(String turmaCli) {
        this.turmaCli = turmaCli;
    }

    public String getDataCli() {
        return dataCli;
    }

    public void setDataCli(String dataCli) {
        this.dataCli = dataCli;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

}
