package Principal;

import Interface.relatorio;

public class Paciente extends Pessoa implements relatorio {
    private String cartaoSus;

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }


    @Override
    public void relatorio() {

    }
}
