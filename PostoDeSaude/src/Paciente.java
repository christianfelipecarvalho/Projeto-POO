import java.time.LocalDate;

public class Paciente extends Pessoa{
    private String cartaoSus;

    public String getCartaoSus() {
        return cartaoSus;
    }

//    public Paciente(Integer codigo, String nome, String cpf, String rg, char uf, String rua, String pais, String bairro, LocalDate dataNascimento, String telefone, Integer cartaoSus) {
//        super(codigo, nome, cpf, rg, uf, rua, pais, bairro, dataNascimento, telefone);
//        this.cartaoSus = cartaoSus;
//    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }


}
