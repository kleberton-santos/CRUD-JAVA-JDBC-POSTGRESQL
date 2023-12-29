package pos_java_jdbc.pos_java_jdbc;


import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;

import dao.UserPosDao;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Leticia");
		userposjava.setEmail("le@gmail.com");
		
		userPosDao.salvar(userposjava);
	}
	
	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();
		
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("-------------------------------");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();
		
		try {
			Userposjava userposjava = dao.buscar(4L);
			System.out.println(userposjava);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		try {
			
			UserPosDao dao = new UserPosDao();
			Userposjava objetoBanco = dao.buscar(4L);
			
			objetoBanco.setNome("Nome Alterado");
			
			dao.atualizar(objetoBanco);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		try {
			UserPosDao dao = new UserPosDao();
			dao.deletar(4L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(11)955665566");
		telefone.setTipo("Casa");
		telefone.setUsuario(6L);
		
		UserPosDao dao = new UserPosDao();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void testeCarregaFoneUser() {
		UserPosDao dao = new UserPosDao();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(6L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFones);
			System.out.println("-------------------------------");
		}
	}
	
	@Test
	public void testeDeleteUserFone() {
		UserPosDao dao = new UserPosDao();
		dao.deleteFonesPorUser(7L);
	}

}
