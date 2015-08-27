package br.com.meu_crud.service.interfaces;

import java.util.List;

import br.com.meu_crud.model.entities.Arquivo;

public interface ArquivoService extends GenericService<Arquivo> {

	public void salvarTodos(List<Arquivo> Arquivos);

}
