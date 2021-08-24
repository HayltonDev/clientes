package io.github.hayltondev.clientes.service;

import io.github.hayltondev.clientes.model.entity.Usuario;
import io.github.hayltondev.clientes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository
                                .findByUsername(username)
                                .orElseThrow(()-> new UsernameNotFoundException("Login não encontrado"));
        //como não quero implementar a interface UserDetails direto na classe Usuario, existe um builder para isso

        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
