package model;


public class Triagem extends SinaisVitais {
    private Paciente paciente;
    private Double peso;
    private Double altura;
    FilaDeEspera filaDeEspera;


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public FilaDeEspera getFilaDeEspera() {
        return filaDeEspera;
    }

    public void setFilaDeEspera(FilaDeEspera filaDeEspera) {
        this.filaDeEspera = filaDeEspera;
    }

    @Override
    public String toString() {
        return "Triagem{" +
                "paciente=" + this.peso + " "+ this.altura+
                '}';
    }

}
