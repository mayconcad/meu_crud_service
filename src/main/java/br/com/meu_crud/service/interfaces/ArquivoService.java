package br.com.meu_crud.service.interfaces;

import java.util.List;
import java.util.Map;

import br.com.meu_crud.model.entities.Arquivo;

public interface ArquivoService {

	public List<Arquivo> autocompletar(Map<String, Object> params);

	public void salvarTodos(List<Arquivo> Arquivos);

}
