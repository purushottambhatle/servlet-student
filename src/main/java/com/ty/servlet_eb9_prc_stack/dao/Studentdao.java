package com.ty.servlet_eb9_prc_stack.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.servlet_eb9_prc_stack.dto.Student;


public class Studentdao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	
	public String getLogin(String email) {
		EntityManager entityManager = getEntityManager();
		String jpql = "select e from Student e where  e.email=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		Student student = (Student) query.getSingleResult();
		return student.getPassword();

	}

}
