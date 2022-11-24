import Interface.fila;

public class Funcionario extends Pessoa implements fila {
    private String cargo;
    private String setor;
    private String emailCorporativo;
    private Integer matricula;
    private String conselho;

    @Override
    public void fila() {

    }

    public  enum CargosFuncionarios{
        RECEPCIONISTA,
        ENFERMEIRO,
        MEDICO;
    }



    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }
}
