package model;

public class BeanUserFone {

	public BeanUserFone() {
		// TODO Auto-generated constructor stub
	}
	
			
		private Long id;
		@Override
		public String toString() {
			return "BeanUserFone [id=" + id + ", nome=" + nome + ", email=" + email + ", numero=" + numero + "]";
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}


		private String nome;
		private String email;
		private String numero;
		

}
