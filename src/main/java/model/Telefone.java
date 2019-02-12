package model;

public class Telefone {

	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getUsuariopessoa() {
		return usuariopessoa;
	}

	public void setUsuariopessoa(Long usuariopessoa) {
		this.usuariopessoa = usuariopessoa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	private String numero;
	private Long usuariopessoa;
	private String tipo;
	
	public Telefone() {
		// TODO Auto-generated constructor stub
	}

}
