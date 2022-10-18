import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();


        Funcionario recepcionista = new Funcionario();
        recepcionista.setCargo("Recepcionista");
        recepcionista.setSetor("Recepção");
        recepcionista.setConselho("");
        recepcionista.setMatricula(1000);
        recepcionista.setNome("Ana");
        recepcionista.setCpf("578.656.999-80");

        funcionarios.add(recepcionista);

        Funcionario recepcionista2 = new Funcionario();
        recepcionista2.setMatricula(1002);
        recepcionista2.setCargo("Recepcionista");


        Funcionario enfermeiro = new Funcionario();
        enfermeiro.setCargo("Enfermeiro");
        enfermeiro.setSetor("Triagem");
        enfermeiro.setConselho("coren");
        enfermeiro.setMatricula(23434);
        enfermeiro.setNome("Paula");
        enfermeiro.setCpf("777.872.247-30");

        funcionarios.add(enfermeiro);

        Medico medico = new Medico();
        medico.setCargo("Medico");
        medico.setSetor("Consultorio");
        medico.setConselho("crm");
        medico.setMatricula(3001);
        medico.setNome("João");
        medico.setEspecialidades("Ortopedista");

        funcionarios.add(medico);


        List<String> cargos = new ArrayList<>();//funcionarios.stream().map(f -> f.getCargo()).collect(Collectors.toList());

        for (Funcionario funcionario : funcionarios) {
            cargos.add(funcionario.getCargo());
        }


        List<String> matriculaGeral = new ArrayList<>();

        for (Funcionario funcionarioMatricula : funcionarios) {
            matriculaGeral.add(String.valueOf(funcionarioMatricula.getMatricula()));
        }


        Object[] confirmacaoMatricula = matriculaGeral.toArray();

        Object[] opcaoInicial = cargos.toArray();//{recepcionista.getCargo(),enfermeiro.getCargo(),medico.getCargo()};

        Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual sistema você quer acessar:",
                "MENU", 1, null, opcaoInicial, "");

        List<String> nova = new ArrayList<>();
        for (Funcionario funcionarioMatricula : funcionarios) {
            nova.add(funcionarioMatricula.getMatricula().toString().substring(0, 1));
        }

        System.out.println("> " + nova);

        Object[] aux = new Object[1];
        int i = 0;
        for (Object obj : confirmacaoMatricula) {
            System.out.println(">>>>"+(String)obj.toString().substring(0, 1));
            if (Integer.valueOf(obj.toString().substring(0, 1)) == 1) {
                aux[i] = obj;
            }
        }
        System.out.println(">>"+ aux);
        System.out.println(">>"+ aux.length);

        if (selecionado.equals(cargos.get(0)) && nova.contains("1")) {
            String confirmacao = (String) JOptionPane.showInputDialog(null,
                    "Você selecionou Recepcionista? Digite o codigo da matricula:", "Confirmação", 1,
                    null, aux, " ");


            Paciente paciente = new Paciente();
            String[] cadastroPaciente = {"Nome", "CPF", "RG", "Cartão do SUS"};
            Object selecao = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
                    "MENU", 3, null, cadastroPaciente, "");
            if (selecao.equals("Nome")) {
                String nome = JOptionPane.showInputDialog("Escreva o nome do paciente:");
                paciente.setNome(nome);
                System.out.println(paciente.getNome());

                String[] cadastroPaciente2 = {"CPF", "RG", "Cartão do SUS"};
                Object selecao2 = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
                        "MENU", 3, null, cadastroPaciente2, "");
            }
        }
        if (selecionado.equals(cargos.get(1))) {
            String confirmacao1 = (String) JOptionPane.showInputDialog(null,
                    "Você selecionou Enfermeiro? Digite o codigo da matricula:", "Confirmação", 1,
                    null, confirmacaoMatricula, " ");


//                 Object selecao = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
//                         "MENU", 3, null, cadastroPaciente, "");
//                 if (selecao.equals("Nome")) {
//                     String nome = JOptionPane.showInputDialog("Escreva o nome do paciente:");
//                     paciente.setNome(nome);
//                     System.out.println(paciente.getNome());
//
//                     String[] cadastroPaciente2 = { "CPF", "RG", "Cartão do SUS"};
//                     Object selecao2 = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
//                             "MENU", 3, null, cadastroPaciente2, "");
        }

    }
}


