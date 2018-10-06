package net.cnr.projectJKCSBackEnd.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.cnr.projectJKCSBackEnd.dao.EmployeeDao;
import net.cnr.projectJKCSBackEnd.dto.Employee;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	public SessionFactory sessionFactory;
	@Override
	public List<Employee> getAllEmployee() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Employee", Employee.class).getResultList();
	}

	
	@Override
	public Employee getEmployeeById(Integer id) {
		
		return sessionFactory.getCurrentSession().get(Employee.class, Integer.valueOf(id));
	}

	@Override
	public List<Employee> getActiveEmployee() {
		String selectActiveEmployee = "FROM Employee WHERE isActive = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveEmployee, Employee.class)
				.setParameter("active", true)
					.getResultList();
	}
	
	

	@Override
	public boolean createEmployee(Employee employee) {
		
		try {
			sessionFactory.getCurrentSession().persist(employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	
	@Override
	public boolean updateEmployee(Employee employee) {
		
		try {
			sessionFactory.getCurrentSession().update(employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		
		employee.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}



	
}
