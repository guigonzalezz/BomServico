package lp3.bomservico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lp3.bomservico.model.Anuncio;
import lp3.bomservico.model.TipoServico;
import lp3.bomservico.repository.TipoServicoRepository;

@Service
public class TipoServicoService {
	
	@Autowired
	private TipoServicoRepository tipoServicoRepository;
	
	public TipoServico salvar(String nome) {
		TipoServico tipo_servico = new TipoServico(nome);
		return tipoServicoRepository.save(tipo_servico);
	}
	
	public TipoServico buscarPorId(long id) {
		return tipoServicoRepository.findById(id).get();
	}
	
	public void atualizar(long id, String nome) {
		TipoServico tipo_servico = tipoServicoRepository.findById(id).get();
		tipo_servico.setNome(nome);
		tipoServicoRepository.save(tipo_servico);
	}
	
	public Iterable<TipoServico> listar() {
		Iterable<TipoServico> tipo_servicos =tipoServicoRepository.findAll();
		return tipo_servicos;
	}
	
	
	public void deletar(long id) {
		tipoServicoRepository.deleteById(id);
	}
}
