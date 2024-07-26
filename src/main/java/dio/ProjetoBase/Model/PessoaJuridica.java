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
public class PessoaJuridica extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_Cliente")
    private Integer id;

    private String CNPJ;

    @ManyToOne
    private enderecoCliente endereco;

    @ManyToOne
    private Telefones telefone;

    public PessoaJuridica(String nome, int idade, String Sexo, String CNPJ){
        super(nome, idade, Sexo);
        this.CNPJ = CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public Telefones getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefones telefone) {
        this.telefone = telefone;
    }

    public enderecoCliente getEndereco() {
        return endereco;
    }

    public void setEndereco(enderecoCliente endereco) {
        this.endereco = endereco;
    }


}
