package aplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import dominio.Funcionario;

public class Program {

	public static void main(String[] args) {
		
//		Funcionario f1 = new Funcionario(null, "Pablo", "p@ablo.com");
//		Funcionario f2 = new Funcionario(null, "Heitor", "h@eitor.com");
//		Funcionario f3 = new Funcionario(null, "Cinthia", "c@inthia.com");
//		
//		System.out.println(f1);
//		System.out.println(f2);
//		System.out.println(f3);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
//		em.getTransaction().begin();
//		
//		em.persist(f1);
//		em.persist(f2);
//		em.persist(f3);
//		
//		em.getTransaction().commit();
		
		Integer escolha = Integer.parseInt(JOptionPane.showInputDialog("Forneca o ID para pesquisa"));
		Funcionario func = em.find(Funcionario.class, escolha);
		System.out.println(func);
		em.getTransaction().begin();
		em.remove(func);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		System.out.println("Ok");
		
	}

}
