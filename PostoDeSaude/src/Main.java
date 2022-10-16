import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {

        Funcionario recepcionista = new Funcionario();
        recepcionista.setCargo("Recepcionista");
        recepcionista.setSetor("Recepção");
        recepcionista.setConselho("");
        recepcionista.setMatricula(1);
        recepcionista.setNome("Ana");
        recepcionista.setCpf("578.656.999-80");

        Funcionario enfermeiro = new Funcionario();
        enfermeiro.setCargo("Enfermeiro");
        enfermeiro.setSetor("Triagem");
        enfermeiro.setConselho("coren");
        enfermeiro.setMatricula(2);
        enfermeiro.setNome("Paula");
        enfermeiro.setCpf("777.872.247-30");

        Medico medico = new Medico();
        medico.setCargo("Medico");
        medico.setSetor("Consultorio");
        medico.setConselho("crm");
        medico.setMatricula(3);
        medico.setNome("João");
        medico.setEspecialidades("Ortopedista");


            Object[] opcaoInicial = {recepcionista.getCargo(),enfermeiro.getCargo(),medico.getCargo()};


         Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual sistema você quer acessar:",
                 "MENU", 3,null, opcaoInicial,"");

         if (selecionado.equals(recepcionista.getCargo())){
             String confirmacao = JOptionPane.showInputDialog(null,"Você selecionou Recepcionista? Digite o codigo da matricula:");
            if(Integer.valueOf(confirmacao).equals(recepcionista.getMatricula())) {
                Paciente paciente = new Paciente();
                String[] cadastroPaciente = {"Nome", "CPF", "RG", "Cartão do SUS"};
                Object selecao = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
                        "MENU", 3, null, cadastroPaciente, "");
                if (selecao.equals("Nome")) {
                    String nome = JOptionPane.showInputDialog("Escreva o nome do paciente:");
                    paciente.setNome(nome);
                    System.out.println(paciente.getNome());

                    String[] cadastroPaciente2 = { "CPF", "RG", "Cartão do SUS"};
                    Object selecao2 = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
                            "MENU", 3, null, cadastroPaciente2, "");
                }
            }else{
                return;
            }


         }else if(selecionado.equals(enfermeiro.getCargo())){
             JOptionPane.showConfirmDialog(null,"Você selecionou Enfermeiro?");

         }
         else if (selecionado.equals(medico.getCargo())){
             JOptionPane.showConfirmDialog(null,"Você selecionou Médico?");

         }

    }

}
