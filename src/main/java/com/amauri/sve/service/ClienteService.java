package com.amauri.sve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amauri.sve.entity.Cliente;
import com.amauri.sve.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);
		if(!clienteEncontrado.isPresent()) {
			return null;
		} 
		
		return clienteEncontrado.get();
	}
}
