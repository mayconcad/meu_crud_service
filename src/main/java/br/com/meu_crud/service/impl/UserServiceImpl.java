package br.com.meu_crud.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.meu_crud.model.entities.Usuario;
import br.com.meu_crud.model.repository.interfaces.UserRepository;
import br.com.meu_crud.service.interfaces.UserService;

@Service("userServiceImpl")
@Transactional
@Lazy
public class UserServiceImpl implements UserService, Serializable {

	private static final long serialVersionUID = -2481803605810539357L;

	@Inject
	private UserRepository userRepository;

	@Inject
	private PasswordEncoder passwordEncoder;

	public void save(Usuario entity) {
		entity.setPassword(encodePassword(entity.getPassword()));
		entity.setAtivo(true);
		entity.setCreatedAt(new Date());
		userRepository.save(entity);
	}

	public void remove(Usuario entity) {
		entity.setAtivo(false);
		userRepository.save(entity);
	}

	@Transactional(readOnly = true)
	public Iterable<Usuario> find(Usuario entity, Sort sort, int firstResult,
			int maxResults) {
		return null;
	}

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Usuario user = userRepository.loadUserByUsername(username);
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), user.isEnabled(),
				user.isAccountNonExpired(), user.isCredentialsNonExpired(),
				user.isAccountNonLocked(), user.getAuthorities());
	}

	public void changePassword(String currentPassword, String newPassword) {

	}

	public UserDetails loadCurrentUser() {
		Usuario user = userRepository.loadCurrentUser();
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), user.isEnabled(),
				user.isAccountNonExpired(), user.isCredentialsNonExpired(),
				user.isAccountNonLocked(), user.getAuthorities());

	}

	public Usuario loadByUsername(String username) {
		return userRepository.loadUserByUsername(username);
	}

	private String encodePassword(String password) {
		return passwordEncoder.encodePassword(password, null);
	}

	public void edite(Usuario entity) {
		entity.setPassword(encodePassword(entity.getPassword()));
		userRepository.save(entity);
	}

	public List<Usuario> buscar(Map<String, Object> params) {
		return userRepository.buscar(params);
	}

	public void forceRemove(Usuario entity) {
		userRepository.delete(entity);
	}

	public Usuario load(long id) {
		return userRepository.findOne(id);
	}

}
