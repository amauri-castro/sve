package com.amauri.sve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amauri.sve.entity.Cliente;
import com.amauri.sve.service.ClienteService;

@RequestMapping("/clientes")
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		return ResponseEntity.ok(clienteService.listar());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
		Cliente cliente = clienteService.buscarPorId(id);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
}
