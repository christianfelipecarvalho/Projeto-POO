package repository;

import model.Consulta;

import java.util.ArrayList;
import java.util.List;

public final class ConsultaDAO {
    private static List<Consulta> consultas = new ArrayList<>();

    public static List<Consulta> findConsulta(){
        return consultas;
    }

    public static void save(Consulta consulta){
        consultas.add(consulta);
    }

    public static void save(List<Consulta> consultaList){
        consultas.addAll(consultaList);
    }
}
