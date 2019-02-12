package project_maven_jdbc.project_maven_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserJavaDao;
import model.BeanUserFone;
import model.Telefone;
import model.UserJava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {

		UserJavaDao userJavaDao = new UserJavaDao();
		UserJava userjava = new UserJava();

		userjava.setNome("Conrado");
		userjava.setEmail("conrado@gmail.com");

		userJavaDao.salvar(userjava);

	}

	@Test
	public void initListar() {

		UserJavaDao dao = new UserJavaDao();

		try {

			List<UserJava> list = dao.listar();

			for (UserJava userjava : list) {

				System.out.println(userjava);

				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Test
	public void initBuscar() throws Exception {

		UserJavaDao dao = new UserJavaDao();

		try {

			UserJava userjava = dao.buscar(6L);

			System.out.println(userjava);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {
		try {
			UserJavaDao dao = new UserJavaDao();

			UserJava objetoBanco = dao.buscar(5L);

			objetoBanco.setNome("Leao");

			dao.atualizar(objetoBanco);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void initDeletar() {
		try {
			UserJavaDao dao = new UserJavaDao();

			dao.deletar(12L);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Test
	public void testeInserteTelefone() {

		Telefone telefone = new Telefone();
		telefone.setNumero("(61) 95554-8123");
		telefone.setUsuariopessoa(7L);
		telefone.setTipo("celular");

		UserJavaDao dao = new UserJavaDao();
		dao.salvarTelefone(telefone);
	}

	@Test
	public void testeCarregaUserFone() throws Exception {

		UserJavaDao dao = new UserJavaDao();
		
		//Traz todos os usuários cadastrados com seu respectivo telefone.

		List<BeanUserFone> beanUserFones = dao.listarUserFone();

		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("-------------------------------------------");
		}

	}
	@Test
	public void testeDeleteUserPorFone() {
		
		UserJavaDao dao = new UserJavaDao();
		
		dao.deleteFonesPorUser(4L);
		
		
	}
	
	
}
