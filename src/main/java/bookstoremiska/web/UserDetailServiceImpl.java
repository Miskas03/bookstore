package bookstoremiska.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bookstoremiska.domain.AppUser;
import bookstoremiska.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final UserRepository repository;

	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser curruser = repository.findByUsername(username);
		if (curruser == null){
			throw new UsernameNotFoundException("User not found: " + username);
		}
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
		AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}
}

