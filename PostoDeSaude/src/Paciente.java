import java.time.LocalDate;

public class Paciente extends Pessoa{
    private Integer cartaoSus;

    public Integer getCartaoSus() {
        return cartaoSus;
    }

//    public Paciente(Integer codigo, String nome, String cpf, String rg, char uf, String rua, String pais, String bairro, LocalDate dataNascimento, String telefone, Integer cartaoSus) {
//        super(codigo, nome, cpf, rg, uf, rua, pais, bairro, dataNascimento, telefone);
//        this.cartaoSus = cartaoSus;
//    }

    public void setCartaoSus(Integer cartaoSus) {
        this.cartaoSus = cartaoSus;
    }
}
