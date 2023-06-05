package com.amauri.sve.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amauri.sve.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	public List<Cliente> findByNome(String nome);
}
