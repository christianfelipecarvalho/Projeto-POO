package Principal;

import Interface.relatorios;
import repository.FuncionarioDAO;
import repository.PacienteDAO;
import repository.TriagemDAO;
import sun.awt.SunHints;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//import static Principal.Paciente.chamaCadastroPacientes;
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

    static Object menuOpcaoSistemas() {
        Object[] opcaoInicial = {Funcionario.CargosFuncionarios.RECEPCIONISTA, Funcionario.CargosFuncionarios.ENFERMEIRO,
                Funcionario.CargosFuncionarios.MEDICO};
        Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual sistema você quer acessar:",
                "MENU", 1, null, opcaoInicial, " ");

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
    public static void chamaCadastroPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
//        List<Triagem> triagens = new ArrayList<>();
//        Triagem triagem = new Triagem();
        Paciente paciente = new Paciente();
        pacientes.add(paciente);
        String[] opcaoMenuPaciente = {"DADOS BASICOS", "INFORMAÇÕES COMPLEMENTARES", "VOLTAR", "CANCELAR"};
        int menuCadastroPaciente = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuPaciente, opcaoMenuPaciente[0]);
        switch (menuCadastroPaciente) {
            case 0:
                paciente.setCodigo(0);
                paciente.setAtendimento(0);
                String nome = JOptionPane.showInputDialog("Escreva o NOME do paciente: ");
                paciente.setNome(nome);
//                triagem.setPaciente(paciente);
//                triagens.add(triagem);
//                System.out.println(triagens.get(0));
                System.out.println(paciente.getNome());
                if (nome == null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }

                String cpf = JOptionPane.showInputDialog("Escreva o CPF do paciente:");
                paciente.setCpf(cpf);
                if (cpf== null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }
                System.out.println(paciente.getCpf());
                String rg = JOptionPane.showInputDialog("Escreva o RG do paciente:");
                paciente.setRg(rg);

                if (rg== null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }
                System.out.println(paciente.getRg());

                String cartaoSus = JOptionPane.showInputDialog("Escreva o CARTÃO DO SUS do paciente:");
                paciente.setCartaoSus(cartaoSus);

                if (cartaoSus == null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }
                System.out.println(paciente.getCartaoSus());
//                triagens.add(triagem);
//                TriagemDAO.save(triagem);
                pacientes.add(paciente);
                PacienteDAO.save(paciente);
                chamaCadastroPacientes();
                break;
            case 1:
                String pais = JOptionPane.showInputDialog("Escreva o PAIS do paciente:");
                paciente.setPais(pais);
                System.out.println(paciente.getPais());
                if (pais == null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }
                String uf = JOptionPane.showInputDialog("Escreva o UF do paciente:");
                paciente.setUf(uf);
                if (uf == null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }
                System.out.println(paciente.getUf());
                String bairro = JOptionPane.showInputDialog("Escreva o BAIRRO do paciente:");
                paciente.setBairro(bairro);
                if (bairro == null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }
                System.out.println(paciente.getBairro());

                String rua = JOptionPane.showInputDialog("Escreva o RUA do paciente:");
                paciente.setRua(rua);

                if (rua == null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }
                System.out.println(paciente.getRua());

                String telefone = JOptionPane.showInputDialog("Escreva o TELEFONE do paciente:");
                paciente.setTelefone(telefone);
                if (telefone == null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }
                System.out.println(paciente.getTelefone());

                String dataNacimento = JOptionPane.showInputDialog("Escreva a DATA DE NASCIMENTO do paciente:");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                paciente.setDataNascimento(LocalDate.parse(dataNacimento, formatter));

                if (dataNacimento == null) {
                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                            "AVISO",0);
                    exit(0);
                }
                System.out.println(paciente.getDataNascimento());
//                triagens.add(triagem);
//                TriagemDAO.save(triagem);
                pacientes.add(paciente);
                PacienteDAO.save(paciente);
                menuOpcaoSistemas();
                break;
            case 2:
                menuOpcaoSistemas();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                        "AVISO",0);
                exit(0);
                break;
        }
//        TriagemDAO.save(triagem);
        PacienteDAO.save(pacientes);

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


    public static void ListaPacientes(){
        List<Paciente> pacientes = PacienteDAO.findPacientes();
//        List<Triagem> triagens = TriagemDAO.findTriagem(); quando for usar o for abaixo
        List<String> nomePacientes = new ArrayList<>();
        for (Paciente paciente : pacientes){
                System.out.println(paciente.getNome());
                nomePacientes.add(paciente.getNome());
        }
//        for (Triagem triagem : triagens){
//            System.out.println(triagem.getPaciente().getNome());
//            nomePacientes.add(triagem.getPaciente().getNome());
//        }

        if(nomePacientes.size() == 0){
            JOptionPane.showMessageDialog(null, "NENHUM PACIENTE PARA TRIAGEM!", "AVISO", 0);
            menuOpcaoSistemas();
        }
            JOptionPane.showMessageDialog(null, "PROXIMOS PACIENTES: \n"+nomePacientes);
           int chamandoPaciente = JOptionPane.showConfirmDialog(null, "Deseja chamar o paciente "
                +nomePacientes.get(0)+" para triagem?");
        switch (chamandoPaciente){
            case 0:
                JOptionPane.showMessageDialog(null, "Chamando paciente: "+ nomePacientes.get(0),
                    "AVISO",2);
//                triagens.remove(0);
                nomePacientes.remove(0);
                break;
            case 1:
                chamaMenuEnfermeiro();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                        "AVISO",0);
                exit(0);
        }

    }
    public static void triagem(){
        List<Paciente> pacientes = PacienteDAO.findPacientes();
        List<Triagem> triagens = TriagemDAO.findTriagem();
        List<String> triagem = new ArrayList<>();
        Triagem triagemPaciente = new Triagem();
        for (Paciente paciente : pacientes){
            triagem.add("\nCodigo: "+String.valueOf(paciente.getCodigo())+"\nAtendimento: "+ String.valueOf(paciente.getAtendimento()) +"\nNome: "+paciente.getNome());
         }
        while(triagem.size() != 0) {
//            if (triagem.size() != 0) {
            triagemPaciente.setPeso(Double.valueOf(JOptionPane.showInputDialog(null, "PACIENTE: " + triagem.get(0) + "\nInsira o peso do paciente: ", "TRIAGEM", 0)));
            triagemPaciente.setAltura(Double.valueOf(JOptionPane.showInputDialog(null, "PACIENTE: " + triagem.get(0) + "\nPeso do paciente: " + triagemPaciente.getPeso() +
                    "\nInsira a altura do paciente: ", "TRIAGEM", 0)));
//                triagens.add(triagemPaciente);

            Object[] filaEspera = {triagemPaciente.filaDeEspera.NAOURGENTE, triagemPaciente.filaDeEspera.POUCOURGENTE, triagemPaciente.filaDeEspera.URGENTE, triagemPaciente.filaDeEspera.MUITOURGENTE};
            int menuClassificação = JOptionPane.showOptionDialog(null, "CLASSIFIQUE O PACIENTE:",
                    "MENU CLASSIFICAÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, filaEspera, filaEspera[0]);
            switch (menuClassificação) {
                case 0:
                    triagemPaciente.setFilaDeEspera(FilaDeEspera.NAOURGENTE);
                    int selecao = JOptionPane.showConfirmDialog(null, "Paciente triado com sucesso!\nTempo de espera padrão até 120 minutos.\nDeseja chamar o proximo? ", "TRIAGEM", 1);
                    triagem.remove(0);
                    if (selecao == 1){
                        chamaMenuEnfermeiro();
                    }
                    else if(selecao == 2){
                        JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                                "AVISO",0);
                        exit(0);
                    }
//                    ListaPacientes();
                    // CHAMAR PROXIMO
                    // ADICIONAR NO RELATÓRIO
                    break;
                case 1:
                    triagemPaciente.setFilaDeEspera(FilaDeEspera.POUCOURGENTE);
                    int selecao1 = JOptionPane.showConfirmDialog(null, "Paciente triado com sucesso!\nTempo de espera padrão até 60 minutos.\nDeseja chamar o proximo? ", "TRIAGEM", 1);
                    triagem.remove(0);
                    if (selecao1 == 1){
                        chamaMenuEnfermeiro();
                    }
                    else if(selecao1 == 2){
                        JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                                "AVISO",0);
                        exit(0);
                    }
                    break;
                case 2:
                    triagemPaciente.setFilaDeEspera(FilaDeEspera.URGENTE);
                    int selecao2 = JOptionPane.showConfirmDialog(null, "Paciente triado com sucesso!\nTempo de espera padrão até 30 minutos.\nDeseja chamar o proximo? ", "TRIAGEM", 1);
                    triagem.remove(0);
                    if (selecao2 == 1){
                        chamaMenuEnfermeiro();
                    }
                    else if(selecao2 == 2){
                        JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                                "AVISO",0);
                        exit(0);
                    }

                    break;
                case 3:
                    triagemPaciente.setFilaDeEspera(FilaDeEspera.MUITOURGENTE);
                    JOptionPane.showMessageDialog(null, "PACIENTE NECESSITA DE ATENDIMENTO IMEDIATO LEVE ATÉ O CONSULTÓRIO. ", "TRIAGEM", 0);
                    int selecao3 =JOptionPane.showConfirmDialog(null, "Deseja chamar o proximo? ", "TRIAGEM", 1);
                    triagem.remove(0);
                    if (selecao3 == 1){
                        chamaMenuEnfermeiro();
                    }
                    else if(selecao3 == 2){
                        JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                                "AVISO",0);
                        exit(0);
                    }
                    break;
            }
        }
            triagens.add(triagemPaciente);
            TriagemDAO.save(triagens);
            JOptionPane.showMessageDialog(null, "NENHUM PACIENTE PARA TRIAGEM!", "AVISO", 0);
            chamaMenuEnfermeiro();}
    private static void chamaMenuEnfermeiro(){
        List<Integer> matriculaFuncionario = new ArrayList<>();
        for (Funcionario funcionario : FuncionarioDAO.findFuncionarios(Funcionario.CargosFuncionarios.ENFERMEIRO)) {
            matriculaFuncionario.add(funcionario.getMatricula());
        }
        // mostrarListapaciente(), mostrarClassificacao(), triagem()
        String verificaSenha = JOptionPane.showInputDialog(null, "Digite a senha: ","MENU ENFERMEIRO",3);
        if (verificaSenha == null) {
            JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                    "AVISO",0);
            exit(0);
        }
        if(verificaSenha.equals(matriculaFuncionario.get(0).toString())){
        String[] opcaoMenuEnfermeiro = {"TRIAGEM","MOSTRAR CLASSIFICAÇÃO","RELATÓRIOS", "VOLTAR","CANCELAR"};
        int menuCadastroEnfermeiro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu enfermeiro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuEnfermeiro, opcaoMenuEnfermeiro[0]);
        switch (menuCadastroEnfermeiro){
            case 0:
                // lista pacientes
                ListaPacientes();
                triagem();
                // chama triagem do paciente
            break;
            case 1:
                // MOSTRA A CLASSIFICACAO
                // mostra classificacao pensar em algo melhor
                break;
            case 2:
                // relatorios
                Paciente paciente = new Paciente();
                paciente.relatorioGeral();

                //chamaRelatorioGeral();
                break;
            case 3:
                menuOpcaoSistemas();
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                        "AVISO",0);
                exit(0);
                break;

            default:
                JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                        "AVISO",0);
                exit(0);
        }
    }
         else if (verificaSenha!= matriculaFuncionario.get(0).toString()) {
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
                    // evolução
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
//private static void chamaRelatorioGeral(){
//        List<Paciente> relatorios = PacienteDAO.findPacientes();
//    for (Paciente paciente:relatorios) {
//        relpaciente.getCodigo();
//
//    }
//        //List<String> relatorios = new ArrayList<>();
////        for (relatorios paciente : pacientes){
////        System.out.println(paciente.getNome());
////        relatorios.add(paciente.getNome());
////        }
//        JOptionPane.showMessageDialog(null, "PACIENTES: "+relatorios);
//    }
}



