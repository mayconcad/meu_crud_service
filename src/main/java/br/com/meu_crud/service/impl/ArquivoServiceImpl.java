package br.com.meu_crud.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.meu_crud.model.entities.Arquivo;
import br.com.meu_crud.model.repository.interfaces.ArquivoRepositorio;
import br.com.meu_crud.service.interfaces.ArquivoService;

@Transactional
@Service("arquivoService")
public class ArquivoServiceImpl implements ArquivoService {

	@Inject
	private ArquivoRepositorio arquivoRepositorio;

	public Arquivo salvar(Arquivo entidade) {
		entidade.setAtivo(true);
		return arquivoRepositorio.save(entidade);
	}

	public Arquivo atualizar(Arquivo entidade) {
		return arquivoRepositorio.save(entidade);
	}

	public List<Arquivo> buscar(Map<String, Object> params) {

		return arquivoRepositorio.findAll();
	}

	public void remover(Arquivo entidade) {
		entidade.setAtivo(false);
		arquivoRepositorio.save(entidade);
	}

	public List<Arquivo> autocompletar(Map<String, Object> params) {
		return null;
	}

	public void salvarTodos(List<Arquivo> Arquivos) {
	}

	public Arquivo buscarPorDiaMes(byte dia, byte mes) {
		return null;
	}

}
