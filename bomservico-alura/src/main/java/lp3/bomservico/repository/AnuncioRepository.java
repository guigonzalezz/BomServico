package lp3.bomservico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lp3.bomservico.model.Anuncio;

@Repository
public interface AnuncioRepository extends PagingAndSortingRepository<Anuncio, Long>{
	List<Anuncio> findByTitulo(String titulo);
	List<Anuncio> findByTituloLikeOrTituloLikeOrTituloLike(String titulo1,String titulo2,String titulo3);
	
	@Query("select a from Anuncio a join a.user u where u.username = :username")
	List<Anuncio> findAllByUsuario(@Param("username")String username);
	
	@Query("select a from Anuncio a where a.tipo_servico.nome = ?1")
	List<Anuncio> findByTipoServico(String nome);
	
	@Query("select a from Anuncio a join a.user u where u.username = :username and a.tipo_servico.nome = :tipo_servico")
	List<Anuncio> findByTipoServicoAndUsername(@Param("tipo_servico")String busca, @Param("username") String username);
}
