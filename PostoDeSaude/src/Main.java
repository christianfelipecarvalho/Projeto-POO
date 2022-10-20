import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        Funcionario recepcionista = new Funcionario();
        recepcionista.setCargo(String.valueOf(Funcionario.CargosFuncionarios.RECEPCIONISTA));
        recepcionista.setSetor("Recepção");
        recepcionista.setConselho("");
        recepcionista.setMatricula(1000);
        recepcionista.setNome("Ana");
        recepcionista.setCpf("578.656.999-80");
        recepcionista.getCargo();
        funcionarios.add(recepcionista);

        Funcionario recepcionista2 = new Funcionario();
        recepcionista2.setMatricula(1002);
        recepcionista2.setCargo(String.valueOf(Funcionario.CargosFuncionarios.RECEPCIONISTA));
        funcionarios.add(recepcionista2);

        Funcionario recepcionista3 = new Funcionario();
        recepcionista3.setMatricula(1003);
        recepcionista3.setCargo(String.valueOf(Funcionario.CargosFuncionarios.RECEPCIONISTA));
        funcionarios.add(recepcionista3);
        Funcionario enfermeiro = new Funcionario();
        enfermeiro.setCargo(String.valueOf(Funcionario.CargosFuncionarios.ENFERMEIRO));
        enfermeiro.setSetor("Triagem");
        enfermeiro.setConselho("coren");
        enfermeiro.setMatricula(23434);
        enfermeiro.setNome("Paula");
        enfermeiro.setCpf("777.872.247-30");

        funcionarios.add(enfermeiro);

        Medico medico = new Medico();
        medico.setCargo(String.valueOf(Funcionario.CargosFuncionarios.MEDICO));
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


        //Object[] confirmacaoMatricula = matriculaGeral.toArray();

        Object[] opcaoInicial = {recepcionista.getCargo(),enfermeiro.getCargo(),medico.getCargo()};

        Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual sistema você quer acessar:",
                "MENU", 1, null, opcaoInicial, "");

        if (selecionado.equals(cargos.get(0))) {
            Object [] recepcionistaMatricula = {recepcionista.getMatricula(),recepcionista2.getMatricula(),recepcionista3.getMatricula()};
            Object confirmacao = JOptionPane.showInputDialog(null,
                    "Você selecionou Recepcionista? Digite o codigo da matricula:", "Confirmação", 1,
                    null, recepcionistaMatricula, " ");


            Paciente paciente = new Paciente();
            String[] cadastroPaciente = {"Nome", "CPF", "RG", "Cartão do SUS"};
            String[] cadastroPaciente2 = {"CPF", "RG", "Cartão do SUS"};
            String[] cadastroPaciente3 = {"RG","Cartão do SUS"};
            String[] cadastroPaciente4 = {"Cartão do SUS"};


            Object selecao = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
                    "MENU", 3, null, cadastroPaciente, "");


            if (selecao.equals("Nome")) {
                String nome = JOptionPane.showInputDialog("Escreva o nome do paciente:");
                paciente.setNome(nome);
                System.out.println(paciente.getNome());

            }


                Object selecao2 = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
                        "MENU", 3, null, cadastroPaciente, "");

                if(selecao2.equals("CPF")) {
                    String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
                    paciente.setCpf(cpf);
                    System.out.println(paciente.getCpf());
                }

                    Object selecao3 = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
                            "MENU",3,null,cadastroPaciente,"");

                    if(selecao3.equals("RG")) {
                        String rg = JOptionPane.showInputDialog("Digite o RG do paciente:");
                        paciente.setRg(rg);
                        System.out.println(paciente.getRg());

                    }

                     Object selecao4 = JOptionPane.showInputDialog(null, "Selecione o que você deseja cadastrar:",
                                "MENU",3,null,cadastroPaciente,"");

                     if(selecao4.equals("Cartão do SUS")){
                         String cartaoSUS = JOptionPane.showInputDialog("Digite o cartão do SUS do paciente:");
                         paciente.setCartaoSus(cartaoSUS);
                         System.out.println(paciente.getCartaoSus());
                     }


                    }

                }

                }






//        if (selecionado.equals(cargos.get(1))) {
//
//            String confirmacao1 = (String) JOptionPane.showInputDialog(null,
//                    "Você selecionou Enfermeiro? Digite o codigo da matricula:", "Confirmação", 1,
//                    null, confirmacaoMatricula, " ");
//

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






