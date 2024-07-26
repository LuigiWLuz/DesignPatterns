package dio.ProjetoBase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.ProjetoBase.Model.Pessoa;
import dio.ProjetoBase.Service.metodosDeImplementacaoService;

@RestController
public class ControllerClientes {

    @Autowired
    private metodosDeImplementacaoService service;

    @GetMapping("/{id}")
    public Pessoa buscaPorId(Integer id){
      return service.buscaPorId(id);
    }

    @PostMapping
    public Pessoa inserirCliente(Pessoa pessoa){
        service.inserirCliente(pessoa);
        return pessoa;
    }

    @PutMapping
    public Pessoa atualizarCliente(Pessoa pessoa, Integer id){
        return pessoa;
        
    }
}
