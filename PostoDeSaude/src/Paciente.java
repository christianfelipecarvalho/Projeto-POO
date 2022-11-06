import java.time.LocalDate;

public class Paciente extends Pessoa{
    private String cartaoSus;

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

//    public abstract String mostraPacientes(){
//        this.getNome();
//        return mostraPacientes();
//    }


}
