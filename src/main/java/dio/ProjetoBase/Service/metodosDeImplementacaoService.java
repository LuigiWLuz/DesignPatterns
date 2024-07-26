package dio.ProjetoBase.Service;



import org.springframework.beans.factory.annotation.Autowired;


import dio.ProjetoBase.Model.ContaCorrente;
import dio.ProjetoBase.Model.ContaPoupanca;
import dio.ProjetoBase.Model.Pessoa;
import dio.ProjetoBase.Model.PessoaFisica;
import dio.ProjetoBase.Model.PessoaJuridica;
import dio.ProjetoBase.Model.Telefones;
import dio.ProjetoBase.Model.enderecoCliente;
import dio.ProjetoBase.Repository.RepositoryCliente;
import dio.ProjetoBase.Repository.RepositoryConta;
import dio.ProjetoBase.Repository.RepositoryEndereco;
import dio.ProjetoBase.Repository.RepositoryTelefone;

public class metodosDeImplementacaoService implements serviceImplementationofData {

    @Autowired
    private RepositoryCliente repositoryCliente;

    @Autowired
    private RepositoryConta repositoryConta;

    @Autowired
    private RepositoryEndereco repositoryEndereco;

    @Autowired
    private RepositoryTelefone repositoryTelefone;

    @Autowired
    private apiCEP cepApi;

    @Autowired
    private Telefones novoTelefone;

    @Override
    public Pessoa buscaPorId(Integer id){
       
        if(repositoryCliente.findById(id).isPresent()){
            return (Pessoa) repositoryCliente.findById(id).get();
        }
        else{
            return null;
        }

    }

    @Override
    public void inserirCliente(Pessoa pessoa){
        repositoryCliente.save(pessoa);
    
    }

    @Override
    public void deletarCliente(Integer id,Pessoa pessoa){
        if(buscaPorId(id) != null){
           repositoryCliente.deleteById(id);
        }
        else{
            System.out.println("Cliente não encontrado para exclusão.");
        }
    }

    @Override
    public void atualizarCliente(Integer id,PessoaFisica pessoa){
        if(buscaPorId(id) != null){
            salvarClientecomTodasInformacoes(pessoa);
        }
        else
            inserirCliente(pessoa);
        
    }

    @Override
    public void atualizarCliente(Integer id,PessoaJuridica pessoa){
        if(buscaPorId(id) != null){
            salvarClientecomTodasInformacoes(pessoa);
        }
        else
           inserirCliente(pessoa);
        
    }

    @Override
    public void salvarClientecomTodasInformacoes(PessoaFisica pessoa) {

        String cep = pessoa.getEndereco().getCep();
        enderecoCliente endereco = repositoryEndereco.findById(cep).orElseGet(()-> {
            enderecoCliente novoEndereco = cepApi.consultaCEP(cep);
            repositoryEndereco.save(novoEndereco);
            return novoEndereco;
        });
        pessoa.setEndereco(endereco);

        String tel = pessoa.getTelefone().getTelefone();
        Telefones telefone = repositoryTelefone.findById(tel).orElseGet(()->{
            novoTelefone.setTelefone(tel);
            repositoryTelefone.save(novoTelefone);
            return novoTelefone;
        });
        pessoa.setTelefone(telefone);

        repositoryCliente.save(pessoa);
        
        
    }

    @Override
    public void salvarClientecomTodasInformacoes(PessoaJuridica pessoa) {
        String cep = pessoa.getEndereco().getCep();
        enderecoCliente endereco = repositoryEndereco.findById(cep).orElseGet(()-> {
            enderecoCliente novoEndereco = cepApi.consultaCEP(cep);
            repositoryEndereco.save(novoEndereco);
            return novoEndereco;
        });
        pessoa.setEndereco(endereco);

        String tel = pessoa.getTelefone().getTelefone();
        Telefones telefone = repositoryTelefone.findById(tel).orElseGet(()->{
            novoTelefone.setTelefone(tel);
            repositoryTelefone.save(novoTelefone);
            return novoTelefone;
        });
        pessoa.setTelefone(telefone);
        
        repositoryCliente.save(pessoa);
    }

    @Override
    public void salvarContacomCliente(ContaCorrente contacorrente) {
        if(contacorrente.getPessoaFisica() != null){
            salvarClientecomTodasInformacoes(contacorrente.getPessoaFisica());
        repositoryConta.save(contacorrente);
        }
        else{
            salvarClientecomTodasInformacoes(contacorrente.getPessoaJuridica());
            repositoryConta.save(contacorrente);
        }
    }

    @Override
    public void salvarContacomCliente(ContaPoupanca contacorrente) {
        if(contacorrente.getPessoaFisica() != null){
            salvarClientecomTodasInformacoes(contacorrente.getPessoaFisica());
        repositoryConta.save(contacorrente);
        }
        else{
            salvarClientecomTodasInformacoes(contacorrente.getPessoaJuridica());
            repositoryConta.save(contacorrente);
        }
    }

    

    
    
    

}
