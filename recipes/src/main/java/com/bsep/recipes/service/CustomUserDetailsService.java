package com.bsep.recipes.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bsep.recipes.dto.RegisteredUserDTO;
import com.bsep.recipes.mapper.RegisteredUserMapper;
import com.bsep.recipes.model.Authority;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.model.User;
import com.bsep.recipes.model.UserKnowledgeType;
import com.bsep.recipes.repository.AuthorityRepository;
import com.bsep.recipes.repository.UserRepository;
import com.bsep.recipes.util.InvalidDataException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	protected final Log LOGGER = LogFactory.getLog(getClass());

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	// Funkcija koja na osnovu username-a iz baze vraca objekat User-a
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails u =  userRepository.findByUsername(username);
		if(u!= null)
			return u;
		else
			throw new UsernameNotFoundException(String.format("User with username '%s' not found", username));
	}
		
	public void encodePassword(User u) {
		String pass =  this.passwordEncoder.encode(u.getPassword());
		u.setPassword(pass);
	}
	
	public String encodePassword(String password) {
		return this.passwordEncoder.encode(password);		
	}
	
	public RegisteredUser saveRegisteredUser(RegisteredUserDTO dto) throws InvalidDataException, MailException, UnsupportedEncodingException, InterruptedException {
		User u = userRepository.findByUsername(dto.getUsername());
		if(u != null) {
			throw new InvalidDataException("Username already taken!"); 
		}
		dto.setPassword(encodePassword(dto.getPassword()));
		RegisteredUser ru = RegisteredUserMapper.toRegisteredUser(dto);
		List<Authority> authorities = new ArrayList<Authority>();
		Authority a = authRepository.findById(2).get();
		authorities.add(a);
		ru.setAuthorities(authorities);
		ru.setKnowledge(UserKnowledgeType.BEGINER);
		this.userRepository.save(ru);
		return ru;
	}


}
