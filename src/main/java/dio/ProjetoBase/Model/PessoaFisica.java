package dio.ProjetoBase.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Clientes")
public class PessoaFisica extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_Cliente")
    private Integer id;

    //poderia usar o cpf como PK
    private String CPF;

    @ManyToOne
    private enderecoCliente endereco;

    @ManyToOne
    private Telefones telefone;


    public PessoaFisica(String nome, int idade, String Sexo, String CPF){
        super(nome, idade, Sexo);
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public enderecoCliente getEndereco() {
        return endereco;
    }

    public void setEndereco(enderecoCliente endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(Telefones telefone) {
        this.telefone = telefone;
    }

    public Telefones getTelefone() {
        return telefone;
    }


}
