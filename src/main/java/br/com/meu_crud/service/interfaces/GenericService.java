package br.com.meu_crud.service.interfaces;

import java.util.List;
import java.util.Map;

public interface GenericService<T> {

	public T salvar(T entidade);

	public T atualizar(T entidade);

	public List<T> buscar(Map<String, Object> params);

	public List<T> autocompletar(String valor);

	public void remover(T entidade);
}
