package Principal;

import Interface.relatorios;
import repository.PacienteDAO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Principal.Main.menuOpcaoSistemas;
import static java.lang.System.exit;

public class Paciente extends Pessoa implements relatorios {
    static List<relatorios> relatorios = new ArrayList<>();
    private String cartaoSus;
    private Integer atendimento;

    public static List<Interface.relatorios> getRelatorios() {
        return relatorios;
    }

    public static void setRelatorios(List<Interface.relatorios> relatorios) {
        Paciente.relatorios = relatorios;
    }

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
        Triagem triagem = new Triagem();

        for (Paciente paciente : pacientes){
            relatorio.add("\nCodigo: "+String.valueOf(paciente.getCodigo())+"\nAtendimento: "+ String.valueOf(paciente.getAtendimento())+"\nNome: "+paciente.getNome()+"\nCPF: "+paciente.getCpf());
//            relatorio.add("\nAtendimento: "+ String.valueOf(paciente.getAtendimento()));
//            relatorio.add("\nNome: "+paciente.getNome());
//            relatorio.add("\nCPF: "+paciente.getCpf());
//            //relatorio.add(evolução)
        }
        JOptionPane.showMessageDialog(null, "Pacientes: "+ relatorio, "RELATÓRIO", 1);
    }
//    public static void chamaCadastroPacientes() {
//        List<Paciente> pacientes = new ArrayList<>();
//        //List<relatorios> relatorios = new ArrayList<>();
//        Paciente paciente = new Paciente();
//        pacientes.add(paciente);
////        String[] opcaoMenuPaciente = {"NOME", "CPF", "RG", "CARTÃO SUS", "PAIS",
////                "UF", "BAIRRO", "RUA", "TELEFONE", "DATA DE NASCIMENTO", "VOLTAR"};
//        String[] opcaoMenuPaciente = {"DADOS BASICOS", "INFORMAÇÕES COMPLEMENTARES", "VOLTAR", "CANCELAR"};
//        int menuCadastroPaciente = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
//                "Menu Cadastro",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuPaciente, opcaoMenuPaciente[0]);
//        switch (menuCadastroPaciente) {
//            case 0:
//                //                int codigo = 0;
////                paciente.setCodigo(codigo++);
////                PacienteDAO.save(paciente);
////                relatorios.add(paciente); configurar codigo automatico na classe
//                String nome = JOptionPane.showInputDialog("Escreva o NOME do paciente: ");
//                paciente.setNome(nome);
//                pacientes.add(paciente);
//                PacienteDAO.save(paciente);
//                System.out.println(paciente.getNome());
//                if (nome == null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//                //relatorios.add(paciente);
//                //chamaCadastroPacientes();
//                String cpf = JOptionPane.showInputDialog("Escreva o CPF do paciente:");
//                paciente.setCpf(cpf);
//                //pacientes.add(paciente);
//                //PacienteDAO.save(paciente);
//                //relatorios.add(paciente);
//                if (cpf== null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//                System.out.println(paciente.getCpf());
//
//                //break;
//                String rg = JOptionPane.showInputDialog("Escreva o RG do paciente:");
//                paciente.setRg(rg);
//                //pacientes.add(paciente);
//                //PacienteDAO.save(paciente);
//                //relatorios.add(paciente);
//                if (rg== null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//                System.out.println(paciente.getRg());
//
//                String cartaoSus = JOptionPane.showInputDialog("Escreva o CARTÃO DO SUS do paciente:");
//                paciente.setCartaoSus(cartaoSus);
//                //pacientes.add(paciente);
//                //PacienteDAO.save(paciente);
//                //relatorios.add(paciente);
//                if (cartaoSus == null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//                System.out.println(paciente.getCartaoSus());
//                chamaCadastroPacientes();
//                break;
//            case 1:
//                String pais = JOptionPane.showInputDialog("Escreva o PAIS do paciente:");
//                paciente.setPais(pais);
//                //pacientes.add(paciente);
//                //PacienteDAO.save(paciente);
//                System.out.println(paciente.getPais());
//                if (pais == null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//
//                String uf = JOptionPane.showInputDialog("Escreva o UF do paciente:");
//                paciente.setUf(uf);
//                if (uf == null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//                System.out.println(paciente.getUf());
//
//
//                String bairro = JOptionPane.showInputDialog("Escreva o BAIRRO do paciente:");
//                paciente.setBairro(bairro);
//                //pacientes.add(paciente);
//                //PacienteDAO.save(paciente);
//                if (bairro == null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//                System.out.println(paciente.getBairro());
//
//                String rua = JOptionPane.showInputDialog("Escreva o RUA do paciente:");
//                paciente.setRua(rua);
//                //pacientes.add(paciente);
//                //PacienteDAO.save(paciente);
//                if (rua == null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//                System.out.println(paciente.getRua());
//                //chamaCadastroPacientes();
//                //break;
//
//                String telefone = JOptionPane.showInputDialog("Escreva o TELEFONE do paciente:");
//                paciente.setTelefone(telefone);
//                if (telefone == null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//                System.out.println(paciente.getTelefone());
//
//                String dataNacimento = JOptionPane.showInputDialog("Escreva a DATA DE NASCIMENTO do paciente:");
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                paciente.setDataNascimento(LocalDate.parse(dataNacimento, formatter));
//                //pacientes.add(paciente);
//                //PacienteDAO.save(paciente);
//                if (dataNacimento == null) {
//                    JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                            "AVISO",0);
//                    exit(0);
//                }
//                System.out.println(paciente.getDataNascimento());
//                menuOpcaoSistemas();
//                break;
//            case 2:
//                menuOpcaoSistemas();
//                break;
//            case 3:
//                JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
//                        "AVISO",0);
//                exit(0);
//                break;
//        }
//        PacienteDAO.save(pacientes);
//        //return pacientes.toString();
//    }

//    @Override
//    public String toString() {
//        return "Paciente{" +
//                "Nome='" + getNome() + '\'' +"Cpf: "+ getCpf()+
//                '}';
//    }
}
