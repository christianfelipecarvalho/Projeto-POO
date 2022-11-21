import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public final class PacienteDAO {
    private static List<Paciente> pacientes = new ArrayList<>();

    public static List<Paciente> findPacientes(){
        return pacientes;
    }

    public static void save(Paciente paciente){
        pacientes.add(paciente);
    }

    public static void save(List<Paciente> pacientesList){
        pacientes.addAll(pacientesList);
    }


}
