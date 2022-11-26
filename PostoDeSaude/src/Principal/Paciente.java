package Principal;

import Interface.relatorios;
import repository.PacienteDAO;
import repository.TriagemDAO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Principal.Main.menuOpcaoSistemas;
import static java.lang.System.exit;

public class Paciente extends Pessoa implements relatorios {
    static List<relatorios> relatorios = new ArrayList<>();
    private String cartaoSus;
    private Integer atendimento;

    public static List<Interface.relatorios> getRelatorios() {
        return relatorios;
    }

    public static void setRelatorios(List<Interface.relatorios> relatorios) {
        Paciente.relatorios = relatorios;
    }

    public Integer getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Integer atendimento) {
        Random random = new Random();
        int numero = random.nextInt(1000);
        this.atendimento = numero;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }



    @Override
    public void relatorioGeral() {
        List<Paciente> pacientes = PacienteDAO.findPacientes();
        List<String> relatorio = new ArrayList<>();
        //Triagem triagem = new Triagem();
        List<Triagem> triagens = TriagemDAO.findTriagem();
        List<String> dadosTriagem = new ArrayList<>();

        for (Triagem triagem: triagens ){
            dadosTriagem.add("\nPeso: "+triagem.getPeso() + "\nAltura: "+ triagem.getAltura()+ "\nClassificação: "+ triagem.getFilaDeEspera());
        }

        for (Paciente paciente : pacientes){
            relatorio.add("\nCodigo: "+String.valueOf(paciente.getCodigo())+"\nAtendimento: "+ String.valueOf(paciente.getAtendimento())+
                    "\nNome: "+paciente.getNome()+"\nCPF: "+paciente.getCpf());
        }
        if(relatorio.size() == 0){
            JOptionPane.showMessageDialog(null, "NENHUM PACIENTE CADASTRADO!", "AVISO", 0);
            menuOpcaoSistemas();
        }
        JOptionPane.showMessageDialog(null, "Pacientes: "+ relatorio + "Dados triagem: " + dadosTriagem, "RELATÓRIO", 1);
    }
}
