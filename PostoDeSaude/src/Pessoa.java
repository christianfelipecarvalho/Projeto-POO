import java.time.LocalDate;

public class Pessoa {
    private Integer codigo;
    private String nome;
    private String cpf;
    private String rg;
    private String uf;
    private String rua;
    private String pais;
    private String bairro;
    private LocalDate dataNascimento;
    private String telefone;

//    public Pessoa(Integer codigo, String nome, String cpf, String rg, char uf, String rua, String pais, String bairro, LocalDate dataNascimento, String telefone) {
//        this.codigo = codigo;
//        this.nome = nome;
//        this.cpf = cpf;
//        this.rg = rg;
//        this.uf = uf;
//        this.rua = rua;
//        this.pais = pais;
//        this.bairro = bairro;
//        this.dataNascimento = dataNascimento;
//        this.telefone = telefone;
//    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}