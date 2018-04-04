package standard.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import standard.dao.StandarDao;
import standard.entity.Standard;

@Repository
public class StandardImpl implements StandarDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Standard> getAll() {
		// TODO Auto-generated method stub
		return (List<Standard>) hibernateTemplate.find("from Standard");
	}

	@Override
	public List<Standard> getStan(String title, int pageNumb, int pageSize) {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<List<Standard>>() {
			@Override
			public List<Standard> doInHibernate(Session sess) throws HibernateException, SQLException {
				Criteria criteria = sess.createCriteria(Standard.class); 
				
				if(title!=null&&!title.isEmpty()) {				
					criteria.add(Restrictions.or(Restrictions.like("zhname", "%"+title+"%"), Restrictions.like("std_num", "%"+title+"%")));
				}				
				criteria.setFirstResult((pageNumb-1)*pageSize); 
				criteria.setMaxResults(pageSize);
				return criteria.list();
			}
			
		});
		
	}

	@Override
	public void addStandard(Standard standard) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(standard);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(hibernateTemplate.get(Standard.class, id));
	}
	
	

	@Override
	public int getNum(String title) {
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session sess) throws HibernateException, SQLException {
				Criteria criteria = sess.createCriteria(Standard.class); 
				
				if(title!=null&&!title.isEmpty()) {				
					criteria.add(Restrictions.or(Restrictions.like("zhname", "%"+title+"%"), Restrictions.like("std_num", "%"+title+"%")));
				}		
				criteria.setProjection(Projections.rowCount());
				Number n= (Number) criteria.uniqueResult();
				return n.intValue();
			}
			
		});
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-beans.xml");
		StandarDao cd=(StandarDao) ctx.getBean(StandarDao.class);
	
			System.out.println(cd.getNum("4")); 
		
	}

	@Override
	public Standard fechByid(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Standard.class, id);
	}

	@Override
	public void update(Standard standard) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(standard);
	}

}
