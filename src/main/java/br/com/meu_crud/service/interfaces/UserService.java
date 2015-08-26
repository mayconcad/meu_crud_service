package br.com.meu_crud.service.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.meu_crud.model.entities.Usuario;

public interface UserService extends UserDetailsService {

	void save(Usuario entity);

	void edite(Usuario entity);

	void remove(Usuario entity);

	void forceRemove(Usuario entity);

	Iterable<Usuario> find(Usuario entity, Sort sort, int firstResult, int maxResults);

	UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException;

	void changePassword(String currentPassword, String newPassword);

	UserDetails loadCurrentUser();

	Usuario loadByUsername(String username);

	Usuario load(long id);

	List<Usuario> buscar(Map<String, Object> params);
}
