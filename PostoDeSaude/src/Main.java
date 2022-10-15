import javax.swing.*;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {

        Paciente paciente1 = new Paciente();
        paciente1.setNome("Jenifer");
        paciente1.setCodigo(1);

        Triagem paciente = new Triagem();
        paciente.setPaciente(paciente1);
        paciente.setFilaDeEspera(FilaDeEspera.MUITOURGENTE);




    }
}
