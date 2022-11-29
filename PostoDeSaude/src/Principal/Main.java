package Principal;

import repository.ConsultaDAO;
import repository.FuncionarioDAO;
import repository.PacienteDAO;
import repository.TriagemDAO;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static Principal.FilaDeEspera.*;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
//        try {
            menuOpcaoSistemas();
//        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro no sistema!\n Entre em contato com o suporte!!!",
                    "ERRO", 0);
//        }
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
        Paciente paciente = new Paciente();
        pacientes.add(paciente);
        String[] opcaoMenuPaciente = {"DADOS BASICOS", "INFORMAÇÕES COMPLEMENTARES", "VOLTAR", "CANCELAR"};
        int menuCadastroPaciente = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuPaciente, opcaoMenuPaciente[0]);
        switch (menuCadastroPaciente) {
            case 0:
                paciente.setCodigo(1);
                paciente.setAtendimento(0);
                String nome = JOptionPane.showInputDialog("Escreva o NOME do paciente: ");
                paciente.setNome(nome);
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
                pacientes.add(paciente);
                PacienteDAO.save(paciente);
                System.out.println(PacienteDAO.findPacientes());
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
    public static void listaPacientes(){
        List<Paciente> pacientes = PacienteDAO.findPacientes();
//        List<Triagem> triagens = TriagemDAO.findTriagem(); quando for usar o for abaixo
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
                JOptionPane.showMessageDialog(null, "Chamando paciente: "+ nomePacientes.get(0),
                    "AVISO",2);
                nomePacientes.remove(0);
                triagem();
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

        List<String> triagemList = new ArrayList<>();


        for (Paciente paciente : pacientes){
            triagemList.add("\nCodigo: "+paciente.getCodigo()+"\nAtendimento: "+ paciente.getAtendimento() +"\nNome: "+paciente.getNome());
         }
        for(int i = 0; i <= pacientes.size() - 1;i++) {
            Triagem triagem = new Triagem();
            List<Triagem> triagens = new ArrayList<>();
            triagem.setPeso(Double.valueOf(JOptionPane.showInputDialog(null, "PACIENTE: " + triagemList.get(i) + "\nInsira o peso do paciente: ", "TRIAGEM", 0)));
            triagem.setAltura(Double.valueOf(JOptionPane.showInputDialog(null, "PACIENTE: " + triagemList.get(i) + "\nPeso do paciente: " + triagem.getPeso() +
                    "\nInsira a altura do paciente: ", "TRIAGEM", 0)));
            triagens.add(triagem);
            System.out.println(triagemList);
            System.out.println(triagem.getPeso() + " " + triagem.getAltura());

            // NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR

//            triagem.setFrequenciaCardiaca(Double.valueOf(JOptionPane.showInputDialog(null, "PACIENTE: " + triagemList.get(i) + "\nPeso do paciente: " + triagem.getPeso() +
//                    "\nAltura do paciente: "+ triagem.getAltura() + "\n Insira a frequencia cardiaca: ", "TRIAGEM", 0)));
//
//            triagem.setSaturacao(Double.valueOf(JOptionPane.showInputDialog(null, "PACIENTE: " + triagemList.get(i) + "\nPeso do paciente: " + triagem.getPeso() +
//                    "\nAltura do paciente: "+ triagem.getAltura()+"\nFrequencia cardiaca: "+ triagem.getFrequenciaCardiaca() + "\n Insira a saturação: ", "TRIAGEM", 0)));
//
//            triagem.setPressao(JOptionPane.showInputDialog(null, "PACIENTE: " + triagemList.get(i) + "\nPeso do paciente: " + triagem.getPeso() +
//                    "\nAltura do paciente: "+ triagem.getAltura()+"\nFrequencia cardiaca: "+ triagem.getFrequenciaCardiaca() + "\nSaturação: "
//                    + triagem.getSaturacao()+"\nInsira a pressao: ", "TRIAGEM", 0));
//
//            triagem.setTemperatura(Double.valueOf(JOptionPane.showInputDialog(null, "PACIENTE: " + triagemList.get(i) + "\nPeso do paciente: " + triagem.getPeso() +
//                    "\nAltura do paciente: "+ triagem.getAltura()+"\nFrequencia cardiaca: "+ triagem.getFrequenciaCardiaca() + "\nSaturação: "+ triagem.getSaturacao()+
//                    "\nPressao: " + triagem.getPressao()+"\nInsira a temperatura: ", "TRIAGEM", 0)));
            // NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR

            // NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR NÃO APAGAR
//            triagens.add(triagem);
            System.out.println("save 1 triagem"+ triagem);
            System.out.println("DAO 1"+ TriagemDAO.findTriagem());
            Object[] filaEspera = {triagem.filaDeEspera.NAOURGENTE, triagem.filaDeEspera.POUCOURGENTE, triagem.filaDeEspera.URGENTE, triagem.filaDeEspera.MUITOURGENTE};
            int menuClassificação = JOptionPane.showOptionDialog(null, "CLASSIFIQUE O PACIENTE:",
                    "MENU CLASSIFICAÇÃO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, filaEspera, filaEspera[0]);
            switch (menuClassificação) {
                case 0:
                    triagem.setFilaDeEspera(NAOURGENTE);
                    String selecao = String.valueOf(JOptionPane.showConfirmDialog(null, "Paciente triado com sucesso!\nTempo de espera padrão até 120 minutos.\nDeseja chamar o proximo? ", "TRIAGEM", 1));
                    if (selecao.equals(1) ){
                        chamaMenuEnfermeiro();
                    }
                    else if(selecao.equals(2)){
                        JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                                "AVISO",0);
                        exit(0);
                    }
//                    triagens.add(triagem);
//                    TriagemDAO.save(triagens);
                    break;
                case 1:
                    triagem.setFilaDeEspera(FilaDeEspera.POUCOURGENTE);
                    int selecao1 = JOptionPane.showConfirmDialog(null, "Paciente triado com sucesso!\nTempo de espera padrão até 60 minutos.\nDeseja chamar o proximo? ", "TRIAGEM", 1);
                    triagemList.remove(0);
                    if (selecao1 == 1){
                        chamaMenuEnfermeiro();
                    }
                    else if(selecao1 == 2){
                        JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                                "AVISO",0);
                        exit(0);
                    }
//                    triagens.add(triagem);
//                    TriagemDAO.save(triagens);
                    break;
                case 2:
                    triagem.setFilaDeEspera(URGENTE);
                    int selecao2 = JOptionPane.showConfirmDialog(null, "Paciente triado com sucesso!\nTempo de espera padrão até 30 minutos.\nDeseja chamar o proximo? ", "TRIAGEM", 1);
                    if (selecao2 == 1){
                        chamaMenuEnfermeiro();
                    }
                    else if(selecao2 == 2){
                        JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                                "AVISO",0);
                        exit(0);
                    }
//                    triagens.add(triagem);
//                    TriagemDAO.save(triagens);
                    break;
                case 3:
                    triagem.setFilaDeEspera(FilaDeEspera.MUITOURGENTE);

                    JOptionPane.showMessageDialog(null, "PACIENTE NECESSITA DE ATENDIMENTO IMEDIATO LEVE ATÉ O CONSULTÓRIO. ", "TRIAGEM", 0);
                    int selecao3 =JOptionPane.showConfirmDialog(null, "Deseja chamar o proximo? ", "TRIAGEM", 1);
                    if (selecao3 == 1){
                        chamaMenuEnfermeiro();
                    }
                    else if(selecao3 == 2){
                        JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                                "AVISO",0);
                        exit(0);
                    }
//                    triagens.add(triagem);
//                    TriagemDAO.save(triagens);
                    break;
            }
            System.out.println("list triagens " + triagens);
            System.out.println("DAO 2"+TriagemDAO.findTriagem());
            TriagemDAO.save(triagens);
        }

            System.out.println(TriagemDAO.findTriagem());
            menuOpcaoSistemas();
            JOptionPane.showMessageDialog(null, "NENHUM PACIENTE PARA TRIAGEM!", "AVISO", 3);
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
                listaPacientes();
                //triagem();
                // chama triagem do paciente
            break;
            case 1:
                // MOSTRA A CLASSIFICACAO
                Paciente paciente1 = new Paciente();
                paciente1.mostraClassificacao();
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
            String[] opcaoMenuMedico = {"CONSULTA", "VOLTAR","CANCELAR"};
            int menuCadastroMedico = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu Médico",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuMedico, opcaoMenuMedico[0]);
            switch (menuCadastroMedico){
                case 0:
                    // lista pacientes
                    // evolução
//                    Paciente paciente = new Paciente();
//                    paciente.mostraClassificacao();
                    consulta();
                    // essa é a lista do enfermeiro
                    // chama paciente para consulta com base na lista do enfermeiro do paciente
                    break;
                case 1:
                    menuOpcaoSistemas();
                    break;
                case 2:
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
    public static void consulta(){ /// MUDAR PARA CONSULTA OU EVOLUÇÃO
        List<Paciente> pacientes = PacienteDAO.findPacientes();
        List<String> nomePacientes = new ArrayList<>();
        List<Triagem> triagens = TriagemDAO.findTriagem();
        List<String> classificacao = new ArrayList<>();
        for (int i =0; i <= pacientes.size() -1; i++){
            if (triagens.get(i).getFilaDeEspera().equals(NAOURGENTE)){
                classificacao.add("\nPeso" + triagens.get(i).getPeso()+ "\nAltura: " +triagens.get(i).getAltura()+
                        "Classificação: "+triagens.get(i).getFilaDeEspera());
                nomePacientes.add("\nCodigo: "+ (pacientes.get(i).getCodigo())+"\nAtendimento: "
                        + (pacientes.get(i).getAtendimento())+
                        "\nNome: "+pacientes.get(i).getNome()+"\nCPF: "+pacientes.get(i).getCpf());
            } if (triagens.get(i).getFilaDeEspera().equals(POUCOURGENTE)) {
                classificacao.add("\nPeso" + triagens.get(i).getPeso()+ "\nAltura: " +triagens.get(i).getAltura()+
                        "Classificação: "+triagens.get(i).getFilaDeEspera());
                nomePacientes.add("\nCodigo: "+ (pacientes.get(i).getCodigo())+"\nAtendimento: "
                        + (pacientes.get(i).getAtendimento())+
                        "\nNome: "+pacientes.get(i).getNome());
            }

        }
        for (int i = 0; i <= pacientes.size() -1; i++) {
            List<Consulta> consultas = new ArrayList<>();
            Consulta consulta = new Consulta();
            consulta.setDesfecho(JOptionPane.showInputDialog(null, "\n#######DADOS DO PACIENTE####### " + nomePacientes.get(i) +
                    "\n#######DADOS TRIAGEM#######" + classificacao.get(i) + "\n Evolução: "));
                consultas.add(consulta);
                ConsultaDAO.save(consultas);
        }

        menuOpcaoSistemas();
        if(nomePacientes.size() == 0){
            JOptionPane.showMessageDialog(null, "NENHUM PACIENTE PARA CONSULTA!", "AVISO", 0);
            menuOpcaoSistemas();
        }

    }
}




