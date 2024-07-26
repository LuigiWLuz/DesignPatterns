package dio.ProjetoBase.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contas")
public class ContaPoupanca extends Conta{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idConta;

    @OneToOne
    private PessoaFisica pessoaFisica;

    @OneToOne
    private PessoaJuridica pessoaJuridica;

    public ContaPoupanca(PessoaFisica pessoa) {
        super(pessoa);
    }

    public ContaPoupanca(PessoaJuridica pessoa) {
        super(pessoa);
    }

    @Override
    public void imprimirExtrato() {
       System.out.println("===CONTA POUPANÇA===");
       
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }


    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Integer getIdConta() {
        return idConta;
    }

}
