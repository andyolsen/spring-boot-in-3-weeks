package demo.springdata;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	public Employee getEmployee(long id) {
		return entityManager.find(Employee.class, id);
	}

	public long getEmployeeCount() {
		String jpql = "select count(e) from Employee e";
		TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
		return query.getSingleResult();
	}
    
	public List<Employee> getEmployees() {
		String jpql = "select e from Employee e";
		TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
	    return query.getResultList();
	}
    
	@Transactional
	public void insertEmployee(Employee e) {
		entityManager.persist(e);
	}
	
	@Transactional
	public void employeePayRise(long id, double payRise) {
		Employee emp = entityManager.find(Employee.class, id);
		emp.setDosh(emp.getDosh() + payRise);
	}

	@Transactional
	public void deleteEmployee(long id) {
		Employee emp = entityManager.find(Employee.class, id);
		entityManager.remove(emp);
	}
}
