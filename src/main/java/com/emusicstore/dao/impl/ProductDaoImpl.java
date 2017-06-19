package com.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

/**
 * Implements ProductDao
 * 
 * @author pborsoni
 *
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@Override
	public Product getProductById(int id) {

		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		session.flush();

		return product;
	}

	@Override
	public List<Product> getAllProducts() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> list = query.list();
		session.flush();

		return list;
	}

	@Override
	public void deleteProduct(int id) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id));

		session.flush();

	}

	@Override
	public void updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(product);
		session.flush();

	}

}
