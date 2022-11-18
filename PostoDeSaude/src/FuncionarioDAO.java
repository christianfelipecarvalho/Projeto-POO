import java.util.ArrayList;
import java.util.List;

public final class FuncionarioDAO {
    public static List<Funcionario> funcionarios = new ArrayList<>();

    public static List<Funcionario> findFuncionarios() {
        funcionarios = new ArrayList<>();
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

        return funcionarios;
    }

    public static List<Funcionario> findFuncionarios(Funcionario.CargosFuncionarios cargo) {

        List<Funcionario> funcionariosByCargo = new ArrayList<>();
        for (Funcionario funcionario : findFuncionarios()) {
            if(funcionario.getCargo().equals(cargo.toString())){
                funcionariosByCargo.add(funcionario);
            }
        }

        List<String> cargos = new ArrayList<>();

        for (Funcionario funcionario : FuncionarioDAO.findFuncionarios()) {
            cargos.add(funcionario.getCargo());
        }
        List<String> matriculaGeral = new ArrayList<>();
        for (Funcionario funcionarioMatricula : FuncionarioDAO.findFuncionarios()) {
            matriculaGeral.add(String.valueOf(funcionarioMatricula.getMatricula()));
        }

        return funcionariosByCargo;
    }
}
