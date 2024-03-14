package demo.springdatarepositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest  // Configures in-mem db, and does JPA-related config only.
public class EmployeeRepositoryTests {

    @Autowired
    private TestEntityManager em;  // Has some additional test-related APIs.

    @Autowired
    private EmployeeRepository repository;

    @BeforeEach
    public void setUp()  {
        em.persist(new Employee("Employee1", 10_000, "Sørlandet"));
        em.persist(new Employee("Employee2", 20_000, "Østlandet"));
        em.persist(new Employee("Employee3", 30_000, "Vestlandet"));
        em.persist(new Employee("Employee4", 40_000, "Trøndelag"));
        em.persist(new Employee("Employee5", 50_000, "Sørlandet"));
        em.persist(new Employee("Employee6", 60_000, "Østlandet"));
        em.persist(new Employee("Employee7", 70_000, "Vestlandet"));
        em.persist(new Employee("Employee8", 80_000, "Trøndelag"));
    }

    @Test
    public void testFindByRegion() {
        List<Employee> emps = repository.findByRegion("Østlandet");
        assertEquals(2, emps.size());
    }

    @Test
    public void testFindInSalaryRange() {

        List<Employee> emps = repository.findInSalaryRange(30_000, 60_000);

        assertEquals(4, emps.size());
        assertEmployeeValueEquals(emps.get(0), "Employee3", 30_000, "Vestlandet");
        assertEmployeeValueEquals(emps.get(1), "Employee4", 40_000, "Trøndelag");
        assertEmployeeValueEquals(emps.get(2), "Employee5", 50_000, "Sørlandet");
        assertEmployeeValueEquals(emps.get(3), "Employee6", 60_000, "Østlandet");
    }

    @Test
    public void findByDoshGreaterThan() {

        Pageable pageable = PageRequest.of(1, 2, Sort.Direction.DESC, "dosh");
        Page<Employee> page = repository.findByDoshGreaterThan(30_000, pageable);
        List<Employee> emps = page.getContent();

        assertEquals(2, emps.size());
        assertEmployeeValueEquals(emps.get(0), "Employee6", 60_000, "Østlandet");
        assertEmployeeValueEquals(emps.get(1), "Employee5", 50_000, "Sørlandet");
    }

    private void assertEmployeeValueEquals(Employee employee, String name, double dosh, String region) {
        assertEquals(employee.getName(), name);
        assertEquals(employee.getDosh(), dosh);
        assertEquals(employee.getRegion(), region);
    }
}