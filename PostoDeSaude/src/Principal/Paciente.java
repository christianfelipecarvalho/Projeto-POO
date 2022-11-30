package Principal;

import Interface.relatorios;
import repository.ConsultaDAO;
import repository.PacienteDAO;
import repository.TriagemDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Principal.FilaDeEspera.*;
import static Principal.Main.menuOpcaoSistemas;

public class Paciente extends Pessoa implements relatorios {
    private String cartaoSus;
    private Integer atendimento;

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
        List<String> dados = new ArrayList<>();
        List<Triagem> triagens = TriagemDAO.findTriagem();
        List<String> dadosTriagem = new ArrayList<>();
        List<Consulta> consultas = ConsultaDAO.findConsulta();
        List<String> dadosConsulta = new ArrayList<>();

        for (Triagem triagem: triagens ){
            dadosTriagem.add("\nPeso: "+triagem.getPeso() + "\nAltura: "+ triagem.getAltura()+ "\nClassificação: "+ triagem.getFilaDeEspera());
        }

        for (Paciente paciente : pacientes){
            dados.add("\nCodigo: "+String.valueOf(paciente.getCodigo())+"\nAtendimento: "+ String.valueOf(paciente.getAtendimento())+
                    "\nNome: "+paciente.getNome()+"\nCPF: "+paciente.getCpf());
        }
//        if (consultas.get(0)!=null){
        for (Consulta consulta: consultas){
            dadosConsulta.add("\n Evolução: " + consulta.getDesfecho());
        }
//        }
        for (int i = 0; i <= pacientes.size() - 1; i++){
            relatorio.add("\n#######DADOS DO PACIENTE####### "+ dados.get(i)+"\n#######DADOS DA TRIAGEM####### " + dadosTriagem.get(i)+
                    "\n#######DESFECHO#######" + dadosConsulta.get(i));
        }
        if(relatorio.size() == 0){
            JOptionPane.showMessageDialog(null, "NENHUM PACIENTE CADASTRADO!", "AVISO", 0);
            menuOpcaoSistemas();
        }
        JOptionPane.showMessageDialog(null, "#######RELATÓRIO######### "+ relatorio , "RELATÓRIO", 1);
        menuOpcaoSistemas();
    }
    public static void mostraClassificacao() {
        List<Paciente> pacientes = PacienteDAO.findPacientes();
        List<String> nomePacientes = new ArrayList<>();
        List<Triagem> triagens = TriagemDAO.findTriagem();
        List<String> classificacao = new ArrayList<>();
        List<String> classificacaoList = new ArrayList<>();
        for (int i =0; i <= pacientes.size() -1; i++){
            if (triagens.get(i).getFilaDeEspera().equals(NAOURGENTE)){
                classificacao.add("\nClassificação: "+triagens.get(i).getFilaDeEspera());
                nomePacientes.add("\nCodigo: "+ (pacientes.get(i).getCodigo())+"\nAtendimento: "
                        + (pacientes.get(i).getAtendimento())+
                        "\nNome: "+pacientes.get(i).getNome()+"\nCPF: "+pacientes.get(i).getCpf());
            } if (triagens.get(i).getFilaDeEspera().equals(POUCOURGENTE)) {
                classificacao.add("\nClassificação: "+triagens.get(i).getFilaDeEspera());
                nomePacientes.add("\nCodigo: "+ (pacientes.get(i).getCodigo())+"\nAtendimento: "
                        + (pacientes.get(i).getAtendimento())+
                        "\nNome: "+pacientes.get(i).getNome());
            }
            if (triagens.get(i).getFilaDeEspera().equals(URGENTE)) {
                classificacao.add("\nClassificação: "+triagens.get(i).getFilaDeEspera());
                nomePacientes.add("\nCodigo: "+ (pacientes.get(i).getCodigo())+"\nAtendimento: "
                        + (pacientes.get(i).getAtendimento())+
                        "\nNome: "+pacientes.get(i).getNome());
            }
            if (triagens.get(i).getFilaDeEspera().equals(MUITOURGENTE)) {
                classificacao.add("\nClassificação: "+triagens.get(i).getFilaDeEspera());
                nomePacientes.add("\nCodigo: "+ (pacientes.get(i).getCodigo())+"\nAtendimento: "
                        + (pacientes.get(i).getAtendimento())+
                        "\nNome: "+pacientes.get(i).getNome());
            }
        }
        for (int i = 0; i <= pacientes.size() - 1; i++) {
            classificacaoList.add("\n#######DADOS DO PACIENTE####### " + nomePacientes.get(i) +
                    "\n#######CLASSIFICAÇÃO####### " + classificacao.get(i));
        }
        JOptionPane.showMessageDialog(null, "#######CLASSIFICAÇÃO######### "+ classificacaoList , "RELATÓRIO", 1);
        menuOpcaoSistemas();
}
}
