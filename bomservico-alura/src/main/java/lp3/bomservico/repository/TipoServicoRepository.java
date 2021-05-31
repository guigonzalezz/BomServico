package lp3.bomservico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lp3.bomservico.model.TipoServico;

@Repository
public interface TipoServicoRepository extends CrudRepository<TipoServico, Long>{

}
