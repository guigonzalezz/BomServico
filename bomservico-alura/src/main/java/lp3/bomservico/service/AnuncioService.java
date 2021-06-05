package lp3.bomservico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lp3.bomservico.model.Anuncio;
import lp3.bomservico.model.TipoServico;
import lp3.bomservico.model.User;
import lp3.bomservico.repository.AnuncioRepository;

@Service
public class AnuncioService {
	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	
	public Anuncio salvar(String titulo, String descricao,TipoServico tipo_servico,User usuario) {
		Anuncio anuncio = new Anuncio(titulo, descricao, usuario, tipo_servico);
		return anuncioRepository.save(anuncio);
	}
	
	public void atualizar(long id, String titulo, String descricao,TipoServico tipo_servico) {
		Anuncio anuncio = anuncioRepository.findById(id).get();
		anuncio.setTitulo(titulo);
		anuncio.setDescricao(descricao);
		anuncio.setTipo_servico(tipo_servico);
		anuncioRepository.save(anuncio);
	}
	
	public Iterable<Anuncio> listar() {
		return anuncioRepository.findAll();
	}
	
	public Iterable<Anuncio> findAllByUsuario(String username) {
		return anuncioRepository.findAllByUsuario(username);
	}
	
	public void listarPaginado(int pagina) {
		//Sort.by(Sort.Direction.ASC, “nome do campo”)
		Pageable pageable = PageRequest.of(pagina, 6, Sort.unsorted());
		Page<Anuncio> anuncios = anuncioRepository.findAll(pageable);
//		anuncios.forEach(anuncio -> System.out.println(
//				anuncio.getId() + " - " 
//				+ anuncio.getTitulo() + " - "
//				+ anuncio.getTipo_servico().getNome() + " - "
//				+ anuncio.getUsuario().getNome()
//				));
		System.out.println("Pagina Atual: " + anuncios.getNumber());
		System.out.println("Total elementos: " + anuncios.getTotalElements());
	}
	
	public void deletar(long id) {
		anuncioRepository.deleteById(id);
	}
	
	//BUSCAS
	
	public void buscaAnuncioTitulo(String titulo) {
		List<Anuncio> anuncios = anuncioRepository.findByTitulo(titulo);
//		System.out.println("***"+titulo+"***");
//		anuncios.forEach(anuncio -> System.out.println(
//				anuncio.getId() + " - " 
//				+ anuncio.getTitulo() + " - "
//				+ anuncio.getUsuario().getNome()
//				));
	}
	
	public Anuncio buscaAnuncioId(long id) {
		return anuncioRepository.findById(id).get();
	}
	
	public void buscaAnuncioLikeTitulo(String titulo) {
		
		List<Anuncio> anuncios = anuncioRepository.findByTituloLikeOrTituloLikeOrTituloLike("%"+titulo+"%","%"+titulo,titulo+"%");
	
	}
	
	public Iterable<Anuncio> buscaAnuncioPorTipoServico(String busca) {
		return anuncioRepository.findByTipoServico(busca);
	}
	
	public List<Anuncio> buscaAnuncioPorTipoServicoId(long id) {
		return anuncioRepository.findByTipoServicoId(id);
	}
	
	public List<Anuncio> buscaAnuncioPorTipoServicoEUsuario(String busca, String username) {
		return anuncioRepository.findByTipoServicoAndUsername(busca, username);
	}
}
