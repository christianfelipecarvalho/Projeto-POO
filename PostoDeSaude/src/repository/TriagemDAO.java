package repository;
import Principal.Triagem;
import java.util.ArrayList;
import java.util.List;

public final class TriagemDAO {
    private static List<Triagem> triagens = new ArrayList<>();

    public static List<Triagem> findTriagem(){
        return triagens;
    }

    public static void save(Triagem triagem){
        triagens.add(triagem);
    }

    public static void save(List<Triagem> triagemList){
        triagens.addAll(triagemList);
    }
}
