import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        try {
            menuOpcaoSistemas();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro no sistema!\n Entre em contato com o suporte!!!",
                    "ERRO", 0);
        }

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
            chamaMenuEnfermeiro();
        }
        else if(selecionado ==Funcionario.CargosFuncionarios.MEDICO){
            // CHAMAR MEDICO
            chamaMenuMedico();
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

        String confirmacao = JOptionPane.showInputDialog(null,
                "Digite sua senha:","MENU RECEPCIONISTA",3);
        if (confirmacao == null) {
            JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                    "AVISO",0);
            exit(0);
        }else if(confirmacao.equals(matriculaFuncionrio.get(0).toString())
                || confirmacao.equals(matriculaFuncionrio.get(1)) || confirmacao.equals(matriculaFuncionrio.get(2))){


            chamaConfirmacao();

        }
        else{
            JOptionPane.showMessageDialog(null, "SENHA INVÁLIDA TENTE NOVAMENTE", "ERRO",0);
            chamaRecepcionista();}
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
    }

    private static String chamaCadastroPacientes() {
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
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                chamaCadastroPacientes();
                break;
            case 1:
                String nome = JOptionPane.showInputDialog("Escreva o NOME do paciente: ");
                paciente.setNome(nome);
                pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getNome());
                chamaCadastroPacientes();
                break;
            case 2:
                String cpf = JOptionPane.showInputDialog("Escreva o CPF do paciente:");
                paciente.setCpf(cpf);
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getCpf());
                chamaCadastroPacientes();
                break;
            case 3:
                String rg = JOptionPane.showInputDialog("Escreva o RG do paciente:");
                paciente.setRg(rg);
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getRg());
                chamaCadastroPacientes();
                break;
            case 4:
                String cartaoSus = JOptionPane.showInputDialog("Escreva o CARTÃO DO SUS do paciente:");
                paciente.setCartaoSus(cartaoSus);
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getCartaoSus());
                chamaCadastroPacientes();
                break;
            case 5:
                String pais = JOptionPane.showInputDialog("Escreva o PAIS do paciente:");
                paciente.setPais(pais);
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getPais());
                chamaCadastroPacientes();
                break;
            case 6:
                String uf = JOptionPane.showInputDialog("Escreva o UF do paciente:");
                paciente.setUf(uf);
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getUf());
                chamaCadastroPacientes();
                break;
            case 7:
                String bairro = JOptionPane.showInputDialog("Escreva o BAIRRO do paciente:");
                paciente.setBairro(bairro);
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getBairro());
                chamaCadastroPacientes();
                break;
            case 8:
                String rua = JOptionPane.showInputDialog("Escreva o RUA do paciente:");
                paciente.setRua(rua);
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getRua());
                chamaCadastroPacientes();
                break;
            case 9:
                String telefone = JOptionPane.showInputDialog("Escreva o TELEFONE do paciente:");
                paciente.setTelefone(telefone);
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getTelefone());
                chamaCadastroPacientes();
                break;
            case 10:
                String dataNacimento = JOptionPane.showInputDialog("Escreva a DATA DE NASCIMENTO do paciente:");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                paciente.setDataNascimento(LocalDate.parse(dataNacimento, formatter));
                //pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(paciente.getDataNascimento());
                chamaCadastroPacientes();
                break;
            case 11:
                menuOpcaoSistemas();
                break;
        }
        PacienteDAO.save(pacientes);
        return pacientes.toString();
    }
    private static void ListaPacientes(){
        List<Paciente> pacientes = PacienteDAO.findPacientes();
        List<String> nomePacientes = new ArrayList<>();
        for (Paciente paciente : pacientes){
                System.out.println(paciente.getNome());
                nomePacientes.add(paciente.getNome());
        }
        if(nomePacientes.size() == 0){
            JOptionPane.showMessageDialog(null, "NENHUM PACIENTE PARA TRIAGEM!", "AVISO", 0);
            menuOpcaoSistemas();
        }
            JOptionPane.showMessageDialog(null, "PROXIMOS PACIENTES: \n"+nomePacientes);
           int chamandoPaciente = JOptionPane.showConfirmDialog(null, "Deseja chamar o paciente "
                +nomePacientes.get(0)+" para triagem?");
        switch (chamandoPaciente){
            case 0:
                // conectar com o paciente com o primeiro nome da lista e após remover da lista
                JOptionPane.showMessageDialog(null, "Paciente: "+ nomePacientes.get(0),
                    "AVISO",2);
            nomePacientes.remove(0);
//            System.out.println(nomePacientes);
            break;
            case 1:
                // retornar para menu enfermeiro
                chamaMenuEnfermeiro();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                        "AVISO",0);
                exit(0);
        }

    }
    private static void chamaMenuEnfermeiro(){
        List<Integer> matriculaFuncionario = new ArrayList<>();
        for (Funcionario funcionario : FuncionarioDAO.findFuncionarios(Funcionario.CargosFuncionarios.ENFERMEIRO)) {
            matriculaFuncionario.add(funcionario.getMatricula());
        }
        // mostrarListapaciente(), mostrarClassificacao(), triagem()
        String verificaSenha = JOptionPane.showInputDialog(null, "Digite a senha: ","MENU ENFERMEIRO",3);
        if (verificaSenha== null) {
            JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                    "AVISO",0);
            exit(0);
        }
        if(verificaSenha.equals(matriculaFuncionario.get(0).toString())){
        String[] opcaoMenuEnfermeiro = {"TRIAGEM","MOSTRAR CLASSIFICAÇÃO", "VOLTAR","CANCELAR"};
        int menuCadastroEnfermeiro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu enfermeiro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuEnfermeiro, opcaoMenuEnfermeiro[0]);
        switch (menuCadastroEnfermeiro){
            case 0:
                // lista pacientes
                ListaPacientes();
                // chama triagem do paciente
            break;
            case 1:
                // MOSTRA A CLASSIFICACAO
                // mostra classificacao pensar em algo melhor
                break;
            case 2:
                menuOpcaoSistemas();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                        "AVISO",0);
                exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                        "AVISO",0);
                exit(0);
        }
    } else if (verificaSenha!= matriculaFuncionario.get(0).toString()) {
            JOptionPane.showMessageDialog(null, "SENHA INVÁLIDA TENTE NOVAMENTE", "ERRO",0);
            chamaMenuEnfermeiro();
        }}
    public static void chamaMenuMedico(){
        List<Integer> matriculaFuncionario = new ArrayList<>();
        for (Funcionario funcionario : FuncionarioDAO.findFuncionarios(Funcionario.CargosFuncionarios.MEDICO)) {
            matriculaFuncionario.add(funcionario.getMatricula());
        }
        String verificaSenha = JOptionPane.showInputDialog(null, "Digite a senha: ","MENU MÉDICO",3);
        if (verificaSenha== null) {
            JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                    "AVISO",0);
            exit(0);
        }
        if(verificaSenha.equals(matriculaFuncionario.get(0).toString())){
            String[] opcaoMenuMedico = {"CONSULTA","MOSTRAR CLASSIFICAÇÃO", "VOLTAR","CANCELAR"};
            int menuCadastroMedico = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu Médico",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuMedico, opcaoMenuMedico[0]);
            switch (menuCadastroMedico){
                case 0:
                    // lista pacientes
                    ListaPacientes();// essa é a lista do enfermeiro
                    // chama paciente para consulta com base na lista do enfermeiro do paciente
                    break;
                case 1:
                    // MOSTRA TODAS AS LISTAS NO SISTEMA
                    break;
                case 2:
                    menuOpcaoSistemas();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
            }
        } else if (verificaSenha!= matriculaFuncionario.get(0).toString()) {
            JOptionPane.showMessageDialog(null, "SENHA INVÁLIDA TENTE NOVAMENTE", "ERRO",0);
            chamaMenuMedico();
        }

    }
}



