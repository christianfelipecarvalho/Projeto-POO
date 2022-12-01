package model;

public class SinaisVitais {

    private Double temperatura;
    private Double frequenciaCardiaca;
    private String pressao;
    private Double saturacao;

    public Double getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public Double getSaturacao() {
        return saturacao;
    }

    public void setSaturacao(Double saturacao) {
        this.saturacao = saturacao;
    }

    public void setFrequenciaCardiaca(Double frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }
}
