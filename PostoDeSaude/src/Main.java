import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

        ///TROCAR PARA SWITCH PARA TRATAR A ENTRADA MELHOR

//        int tipoSistema = 0;
//        if (menuOpcaoSistemas().toString().equals("RECEPCIONISTA")){
//            tipoSistema = 0;
//        } else if (menuOpcaoSistemas().toString().equals("ENFERMEIRO")) {
//            tipoSistema = 1;
//        } else if (menuOpcaoSistemas().toString().equals("MEDICO")) {
//            tipoSistema = 2;
//        }
//
//        switch (tipoSistema){
//            case 0:
//                System.out.println("teste");
//                break;
//            case 1:
//                System.out.println("2");
//                break;
//            case 2:
//                System.out.println("3");
//            default:
//                throw new IllegalStateException("Unexpected value: " + tipoSistema);
//        }

        if (menuOpcaoSistemas().equals(Funcionario.CargosFuncionarios.RECEPCIONISTA)) {
            Object[] recepcionistaMatricula = {recepcionista.getMatricula(), recepcionista2.getMatricula(), recepcionista3.getMatricula()};
            Object confirmacao = JOptionPane.showInputDialog(null,
                    "Você selecionou Recepcionista? Selecione sua matricula:", "Confirmação", 1,
                    null, recepcionistaMatricula, " ");

            //String[] cadastroPaciente = {"Nome", "CPF", "RG", "Cartão do SUS"};
            int confirmacaoCadastroPaciente = JOptionPane.showConfirmDialog(null, "Deseja cadastrar o paciente? ");
            if (confirmacaoCadastroPaciente == 0){
                chamaCadastroPacientes();
            }
            else if (confirmacaoCadastroPaciente == 1) {
                // retornar ao menu de opções
                menuOpcaoSistemas();
            } else if (confirmacaoCadastroPaciente == 2) {
                menuOpcaoSistemas();
            }
        }
    }
    private static void chamaCadastroPacientes () {
        List<Paciente> pacientes = new ArrayList<>();
        Paciente paciente = new Paciente();
        pacientes.add(paciente);
        String[] opcaoMenuPaciente = {"CODIGO", "NOME", "CPF", "RG", "CARTÃO SUS", "PAIS",
                "UF", "BAIRRO", "RUA", "TELEFONE", "DATA DE NASCIMENTO", "VOLTAR"};
        int menuCadastroPaciente = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuPaciente, opcaoMenuPaciente[0]);
        switch (menuCadastroPaciente) {
            case 0: // ir para codigo
                String codigo = JOptionPane.showInputDialog("Escreva o CÓDIGO do paciente:");
                paciente.setCodigo(Integer.parseInt(codigo));
                System.out.println(paciente.getCodigo());
                chamaCadastroPacientes();
                break;
            case 1:
                String nome = JOptionPane.showInputDialog("Escreva o NOME do paciente: ");
                paciente.setNome(nome);
                System.out.println(paciente.getNome());
                chamaCadastroPacientes();
                break;
            case 2:
                String cpf = JOptionPane.showInputDialog("Escreva o CPF do paciente:");
                paciente.setCpf(cpf);
                System.out.println(paciente.getCpf());
                chamaCadastroPacientes();
                break;
            case 3:
                String rg = JOptionPane.showInputDialog("Escreva o RG do paciente:");
                paciente.setRg(rg);
                System.out.println(paciente.getRg());
                chamaCadastroPacientes();
                break;
            case 4:
                String cartaoSus = JOptionPane.showInputDialog("Escreva o CARTÃO DO SUS do paciente:");
                paciente.setCartaoSus(cartaoSus);
                System.out.println(paciente.getCartaoSus());
                chamaCadastroPacientes();
                break;
            case 5:
                String pais = JOptionPane.showInputDialog("Escreva o PAIS do paciente:");
                paciente.setPais(pais);
                System.out.println(paciente.getPais());
                chamaCadastroPacientes();
                break;
            case 6:
                String uf = JOptionPane.showInputDialog("Escreva o UF do paciente:");
                paciente.setUf(uf);
                System.out.println(paciente.getUf());
                chamaCadastroPacientes();
                break;
            case 7:
                String bairro = JOptionPane.showInputDialog("Escreva o BAIRRO do paciente:");
                paciente.setBairro(bairro);
                System.out.println(paciente.getBairro());
                chamaCadastroPacientes();
                break;
            case 8:
                String rua = JOptionPane.showInputDialog("Escreva o RUA do paciente:");
                paciente.setRua(rua);
                System.out.println(paciente.getRua());
                chamaCadastroPacientes();
                break;
            case 9:
                String telefone = JOptionPane.showInputDialog("Escreva o TELEFONE do paciente:");
                paciente.setTelefone(telefone);
                System.out.println(paciente.getTelefone());
                chamaCadastroPacientes();
                break;
            case 10:
                String dataNacimento = JOptionPane.showInputDialog("Escreva a DATA DE NASCIMENTO do paciente:");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/AAAA");
                String date = formatter.format(dataNacimento);
                paciente.setDataNascimento(LocalDate.parse(date));
                System.out.println(paciente.getDataNascimento());
                chamaCadastroPacientes();
                break;
            case 11:
                menuOpcaoSistemas();
                break;

        }
    }
    private static Object menuOpcaoSistemas(){
        Object[] opcaoInicial = {Funcionario.CargosFuncionarios.RECEPCIONISTA,Funcionario.CargosFuncionarios.ENFERMEIRO,
        Funcionario.CargosFuncionarios.MEDICO};

        Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual sistema você quer acessar:",
                "MENU", 1, null, opcaoInicial, " ");

        return selecionado;
    }
}



