package br.com.meu_crud.service.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.meu_crud.model.entities.Usuario;

@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@PersistenceContext
	private EntityManager entityManager;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return findByUsername(username);
	}

	private Usuario findByUsername(String username) {
		try {
			Query createNativeQuery = entityManager
					.createNativeQuery("SELECT u.id, u.username, u.password FROM public.user u WHERE u.username = :username ");
			createNativeQuery.setParameter("username", username);
			Object[] obj = (Object[]) createNativeQuery.getResultList().get(0);
			Usuario user = new Usuario();
			BigInteger idUser = ((BigInteger) obj[0]);
			user.setId(idUser.longValue());
			user.setUsername((String) obj[1]);
			user.setPassword((String) obj[2]);
			BigInteger idRole = ((BigInteger) obj[3]);
			return user;

		} catch (NoResultException e) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}
	}
}