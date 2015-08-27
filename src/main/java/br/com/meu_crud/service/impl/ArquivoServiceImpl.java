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

	public Arquivo atualizar(Arquivo entidade) {
		return arquivoRepositorio.save(entidade);
	}

	public List<Arquivo> buscar(Map<String, Object> params) {
		params.put("ativo", true);
		return arquivoRepositorio.buscar(params);
	}

	public void remover(Arquivo entidade) {
		entidade.setAtivo(false);
		arquivoRepositorio.delete(entidade);
	}

	public List<Arquivo> autocompletar(Map<String, Object> params) {
		String valor = params.get("valor") != null ? params.get("valor")
				.toString() : "";
		return arquivoRepositorio.autocompletar(valor);
	}

	public void salvarTodos(List<Arquivo> arquivos) {
		arquivoRepositorio.save(arquivos);
	}

	public Arquivo salvar(Arquivo entidade) {
		entidade.setAtivo(true);
		return arquivoRepositorio.save(entidade);
	}

	public List<Arquivo> autocompletar(String valor) {
		return arquivoRepositorio.autocompletar(valor);
	}

}
