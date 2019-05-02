package fi.employee.employeerecord;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.employee.employeerecord.web.EmployeeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRecordApplicationTests {
	
	@Autowired
	private EmployeeController empc;

	@Test
	public void contextLoads() throws Exception {
		assertThat(empc).isNotNull();
	}

}
