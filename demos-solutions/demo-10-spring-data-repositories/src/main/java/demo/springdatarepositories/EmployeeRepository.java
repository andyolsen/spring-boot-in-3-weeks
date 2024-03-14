package demo.springdatarepositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    // New query for the exercise:
    @Query("delete from Employee e where e.dosh >= ?1 and e.dosh <= ?2")
    @Modifying(flushAutomatically=true, clearAutomatically=true)
    @Transactional
    int deleteInSalaryRange(double from, double to);

    List<Employee> findByRegion(String region);

    @Query("select e from Employee e where e.dosh >= ?1 and e.dosh <= ?2")
    List<Employee> findInSalaryRange(double from, double to);

    Page<Employee> findByDoshGreaterThan(double salary, Pageable pageable);
}