import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        List<String> cargos = new ArrayList<>();

        for (Funcionario funcionario : FuncionarioDAO.findFuncionarios()) {
            cargos.add(funcionario.getCargo());
        }
        List<String> matriculaGeral = new ArrayList<>();
        for (Funcionario funcionarioMatricula : FuncionarioDAO.findFuncionarios()) {
            matriculaGeral.add(String.valueOf(funcionarioMatricula.getMatricula()));
        }
        System.out.println("teste");
        menuOpcaoSistemas();

    }

    private static Object menuOpcaoSistemas() {
        Object[] opcaoInicial = {Funcionario.CargosFuncionarios.RECEPCIONISTA, Funcionario.CargosFuncionarios.ENFERMEIRO,
                Funcionario.CargosFuncionarios.MEDICO};
        Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual sistema você quer acessar:",
                "MENU", 1, null, opcaoInicial, " ");

        //System.out.println(selecionado);

        if(selecionado ==(Funcionario.CargosFuncionarios.RECEPCIONISTA) ){
            chamaRecepcionista();
        }
        else if (selecionado == Funcionario.CargosFuncionarios.ENFERMEIRO){
            // CHAMAR ENFERMEIRO
        }
        else if(selecionado ==Funcionario.CargosFuncionarios.MEDICO){
            // CHAMAR MEDICO
        }
        else if(selecionado == null){
            JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                    "AVISO",0);
            exit(0);
        }
        return selecionado;
    }
    private static void chamaRecepcionista() {
        List<Integer> matriculaFuncionrio = new ArrayList<>();
        for (Funcionario funcionario : FuncionarioDAO.findFuncionarios(Funcionario.CargosFuncionarios.RECEPCIONISTA)) {
            matriculaFuncionrio.add(funcionario.getMatricula());
        }
        Object[] recepcionistaMatricula = matriculaFuncionrio.toArray();// {recepcionista.getMatricula(), recepcionista2.getMatricula(), recepcionista3.getMatricula()};

        Object confirmacao = JOptionPane.showInputDialog(null,
                "Você selecionou Recepcionista? Selecione sua matricula:", "Confirmação", 1,
                null, recepcionistaMatricula, "");
        if (confirmacao == null) {
            JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                    "AVISO",0);
            exit(0);
        }
        else{
            chamaConfirmacao();
        }
    }
    private static void chamaConfirmacao() {
        int confirmacaoCadastroPaciente = JOptionPane.showConfirmDialog(null, "Deseja cadastrar o paciente? ");
        if (confirmacaoCadastroPaciente == 0) {
            chamaCadastroPacientes();
        } else if (confirmacaoCadastroPaciente == 1) {
            // retornar ao menu de opções
            menuOpcaoSistemas();
        } else if (confirmacaoCadastroPaciente == 2) {
            JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                    "AVISO",0);
            exit(0);
        }
        //return chamaConfirmacao();
    }

    private static void chamaCadastroPacientes() {// VER SE VAMOS RETORNAR ALGUMA COISA
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
                pacientes.add(paciente);
                chamaCadastroPacientes();
                break;
            case 1:
                String nome = JOptionPane.showInputDialog("Escreva o NOME do paciente: ");
                paciente.setNome(nome);
                pacientes.add(paciente);
                System.out.println(paciente.getNome());
                chamaCadastroPacientes();
                break;
            case 2:
                String cpf = JOptionPane.showInputDialog("Escreva o CPF do paciente:");
                paciente.setCpf(cpf);
                pacientes.add(paciente);
                System.out.println(paciente.getCpf());
                chamaCadastroPacientes();
                break;
            case 3:
                String rg = JOptionPane.showInputDialog("Escreva o RG do paciente:");
                paciente.setRg(rg);
                pacientes.add(paciente);
                System.out.println(paciente.getRg());
                chamaCadastroPacientes();
                break;
            case 4:
                String cartaoSus = JOptionPane.showInputDialog("Escreva o CARTÃO DO SUS do paciente:");
                paciente.setCartaoSus(cartaoSus);
                pacientes.add(paciente);
                System.out.println(paciente.getCartaoSus());
                chamaCadastroPacientes();
                break;
            case 5:
                String pais = JOptionPane.showInputDialog("Escreva o PAIS do paciente:");
                paciente.setPais(pais);
                pacientes.add(paciente);
                System.out.println(paciente.getPais());
                chamaCadastroPacientes();
                break;
            case 6:
                String uf = JOptionPane.showInputDialog("Escreva o UF do paciente:");
                paciente.setUf(uf);
                pacientes.add(paciente);
                System.out.println(paciente.getUf());
                chamaCadastroPacientes();
                break;
            case 7:
                String bairro = JOptionPane.showInputDialog("Escreva o BAIRRO do paciente:");
                paciente.setBairro(bairro);
                pacientes.add(paciente);
                System.out.println(paciente.getBairro());
                chamaCadastroPacientes();
                break;
            case 8:
                String rua = JOptionPane.showInputDialog("Escreva o RUA do paciente:");
                paciente.setRua(rua);
                pacientes.add(paciente);
                System.out.println(paciente.getRua());
                chamaCadastroPacientes();
                break;
            case 9:
                String telefone = JOptionPane.showInputDialog("Escreva o TELEFONE do paciente:");
                paciente.setTelefone(telefone);
                pacientes.add(paciente);
                System.out.println(paciente.getTelefone());
                chamaCadastroPacientes();
                break;
            case 10:
                String dataNacimento = JOptionPane.showInputDialog("Escreva a DATA DE NASCIMENTO do paciente:");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                paciente.setDataNascimento(LocalDate.parse(dataNacimento, formatter));
                pacientes.add(paciente);
                System.out.println(paciente.getDataNascimento());
                chamaCadastroPacientes();
                break;
            case 11:
                menuOpcaoSistemas();
                break;
        }
       // return chamaCadastroPacientes(); VER SE VAMOS RETORNAR ALGO OU NÃO
    }
    private static String mostraListaPaciente(){
       //CRIAR UM RELATORIO

        return mostraListaPaciente();
    }
}



