package com.amauri.sve.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sq")
	@SequenceGenerator(name = "cliente_sq", sequenceName = "scliente_sq", initialValue = 1, allocationSize = 1)
	private Long id;
	private String nome;
	private String celular;
	private Boolean whatsapp;

}
