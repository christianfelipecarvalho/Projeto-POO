package Principal;
import Interface.relatorios;
import repository.PacienteDAO;
import static Principal.Main.ListaPacientes;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Triagem extends SinaisVitais {
    private Paciente paciente;
    private Double peso;
    private Double altura;
    private FilaDeEspera filaDeEspera;

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
    public void triagem(){
        List<Paciente> pacientes = PacienteDAO.findPacientes();
        List<String> triagem = new ArrayList<>();
        Triagem triagemPaciente = new Triagem();
        for (Paciente paciente : pacientes){
            triagem.add("\nCodigo: "+String.valueOf(paciente.getCodigo())+"\nAtendimento: "+ String.valueOf(paciente.getAtendimento()) +"\nNome: "+paciente.getNome());
//         }
        triagemPaciente.setPeso(Double.valueOf(JOptionPane.showInputDialog(null, "PACIENTE: "+triagem.get(0)+ "\nInsira o peso do paciente: ","TRIAGEM" ,0)));
        triagemPaciente.setAltura(Double.valueOf(JOptionPane.showInputDialog(null, "PACIENTE: "+triagem.get(0)+"\nPeso do paciente: "+triagemPaciente.getPeso()+
                "\nInsira a altura do paciente: ","TRIAGEM" ,0)));
        Object [] filaEspera = {triagemPaciente.filaDeEspera.NAOURGENTE,triagemPaciente.filaDeEspera.POUCOURGENTE,triagemPaciente.filaDeEspera.URGENTE,triagemPaciente.filaDeEspera.MUITOURGENTE};
            int menuClassificação = JOptionPane.showOptionDialog(null, "CLASSIFIQUE O PACIENTE:",
                    "MENU CLASSIFICAÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, filaEspera, filaEspera[0]);
            switch (menuClassificação) {
                case 0:
                    JOptionPane.showConfirmDialog(null, "Paciente triado com sucesso!\nTempo de espera padrão até 120 minutos.\nDeseja chamar o proximo? ", "TRIAGEM", 1);
                    triagem.remove(0);
                    ListaPacientes();
                    // CHAMAR PROXIMO
                    // ADICIONAR NO RELATÓRIO
                    break;
                case 1:
                    JOptionPane.showConfirmDialog(null, "Paciente triado com sucesso!\nTempo de espera padrão até 60 minutos.\nDeseja chamar o proximo? ", "TRIAGEM", 1);
                    // CHAMAR PROXIMO
                    // ADICIONAR NO RELATÓRIO
                    break;
                case 2:
                    JOptionPane.showConfirmDialog(null, "Paciente triado com sucesso!\nTempo de espera padrão até 30 minutos.\nDeseja chamar o proximo? ", "TRIAGEM", 1);
                    // CHAMAR PROXIMO
                    // ADICIONAR NO RELATÓRIO
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "PACIENTE NECESSITA DE ATENDIMENTO IMEDIATO LEVE ATÉ O CONSULTÓRIO. ", "TRIAGEM", 0);
                    JOptionPane.showConfirmDialog(null, "Deseja chamar o proximo? ", "TRIAGEM", 1);
                    // CHAMAR PROXIMO
                    // ADICIONAR NO RELATÓRIO
                    break;
    }
}}
}
