package dio.ProjetoBase.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dio.ProjetoBase.Model.Conta;

@Repository
public interface RepositoryConta extends CrudRepository<Conta,Integer> {

}
