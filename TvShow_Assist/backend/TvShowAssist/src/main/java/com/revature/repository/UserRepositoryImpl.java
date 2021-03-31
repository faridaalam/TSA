package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import com.revature.model.FavShows;
import com.revature.model.User;
@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository{
	
	private Logger logger = Logger.getLogger(UserRepositoryImpl.class);


	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserRepositoryImpl() {
		logger.trace("Injection session factory bean");
	}

	@Override
	public void save(User user) {
	
		logger.info("User Tried to Register");	
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Override
	public boolean saveShow(FavShows favshow) {
		sessionFactory.getCurrentSession().save(favshow);
		return true;
	
	
}

	@Override
	public List<Object> findById1(FavShows favshow) {
		
		try {
			System.out.println(favshow.getUserHolder().getId());
			return  sessionFactory.getCurrentSession().createCriteria(FavShows.class).add(Restrictions.like("user_fk", favshow.getUserHolder().getId()))
					.list();
//			return (List<Object>) sessionFactory.getCurrentSession().createQuery("select sId FROM FavShows WHERE user_fk = " + favshow.getUserHolder().getId());
			
//			String hql = "FROM favshows AS E";
//			
//			Query query = session.createQuery(hql);
//			List results = query.list();
//			return select user_fk FROM favshows WHERE user_fk = favshow.getUserHolder().getId())
		}catch (IndexOutOfBoundsException e){
			logger.debug(e);
			return null;
		}
		
	}

	@Override
	public List<User> findAll() {
		logger.info("User Tried to find all Users");	
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User findById(int id) {
		
		try {
			logger.info("User Tried to findbyId");	
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("id", id))
					.list().get(0);
		}catch (IndexOutOfBoundsException e){
			logger.debug(e);
			return null;
		}
	}

	@Override
	public User findByEmail(String email) {
		try {System.out.println("HIT THE userRepository with "+email);
		logger.info("HIT THE userRepository with"+email);	
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("email", email))
					.list().get(0);
		}catch (IndexOutOfBoundsException e){
			logger.debug(e);
			return null;
		}
	}

	@Override
	public void update(User user) {
		logger.info("User tried to update"+user);
		sessionFactory.getCurrentSession().update(user);
	}

	
}
