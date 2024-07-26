package dio.ProjetoBase.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dio.ProjetoBase.Model.enderecoCliente;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface apiCEP {

    @GetMapping("/{cep}/json/")
    enderecoCliente consultaCEP(@PathVariable("cep") String cep);

}
