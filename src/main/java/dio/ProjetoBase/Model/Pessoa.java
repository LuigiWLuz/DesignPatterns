package dio.ProjetoBase.Model;

public class Pessoa {

    private String nome;
    private String Sexo;
    private int idade;
    

    public Pessoa(String nome, int idade,String Sexo){
        this.nome = nome;
        this.idade = idade;
        this.Sexo = Sexo;

    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }




}
