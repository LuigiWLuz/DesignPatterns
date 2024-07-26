package dio.ProjetoBase.Model;

public abstract class Conta implements iConta {

    private static final int AGENCIA = 234;
    private static int contaINIT = 1;
    protected int agencia;
    protected int conta;
    protected PessoaFisica pessoaFisica;
    protected PessoaJuridica pessoaJuridica;
    protected Double saldo;

    public Conta(PessoaFisica pessoaFisica){
        this.pessoaFisica = pessoaFisica;
        this.agencia = AGENCIA;
        this.conta = contaINIT++;

    }

    public Conta(PessoaJuridica pessoaJuridica){
        this.pessoaJuridica  = pessoaJuridica;
        this.agencia = AGENCIA;
        this.conta = contaINIT++;

    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public Double getSaldo() {
        return saldo;
    }


    public void sacar(Double valor){
        if(valor > saldo){
            System.out.println("Saldo insuficiente");
        }
        else{
            saldo -= valor;
            System.out.println("Saldo efetuado com sucesso!");
        }
    }

    public void depositar(Double valor){
        System.out.println("Deposito efetuado com sucesso");
        saldo += valor;
    }

    public void transferir(Conta contaDestino,Double valor){           
        sacar(valor);
        if(valor <= saldo)
          contaDestino.depositar(valor);
    }


}
