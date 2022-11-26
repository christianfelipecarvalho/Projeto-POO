package Principal;

import Interface.relatorios;
import repository.PacienteDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa implements relatorios {
    static List<relatorios> relatorios = new ArrayList<>();
    private String cartaoSus;

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
        for (Paciente paciente : pacientes){
//            relatorio.add("Código: "+paciente.getCodigo()+ " ||" + "Nome: "+paciente.getNome()+ "\n"
//                    +"Cpf: "+paciente.getCpf()+ "\n" + "Bairro: "+ paciente.getBairro());
            relatorio.add(paciente.getNome());
//            relatorio.add(paciente.getCpf());
        }
        JOptionPane.showMessageDialog(null, "Pacientes: "+ relatorio, "RELATÓRIO", 1);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "Nome='" + getNome() + '\'' +"Cpf: "+ getCpf()+
                '}';
    }
}
