package dio.ProjetoBase.Service;

import dio.ProjetoBase.Model.ContaCorrente;
import dio.ProjetoBase.Model.ContaPoupanca;
import dio.ProjetoBase.Model.Pessoa;
import dio.ProjetoBase.Model.PessoaFisica;
import dio.ProjetoBase.Model.PessoaJuridica;

public interface serviceImplementationofData {

    public void inserirCliente(Pessoa pessoa);
    public void deletarCliente(Integer id, Pessoa pessoa);
    public void atualizarCliente(Integer id,PessoaFisica pessoa);
    public void atualizarCliente(Integer id,PessoaJuridica pessoa);
    public Pessoa buscaPorId(Integer id);

    public void salvarClientecomTodasInformacoes(PessoaFisica pessoa);

    public void salvarClientecomTodasInformacoes(PessoaJuridica pessoa);

    public void salvarContacomCliente(ContaCorrente contacorrente);

    public void salvarContacomCliente(ContaPoupanca contacorrente);
}
