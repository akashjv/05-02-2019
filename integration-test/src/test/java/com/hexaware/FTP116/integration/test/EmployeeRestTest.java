package com.hexaware.FTP116.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class EmployeeRestTest {

	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException, ParseException {
		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = "2008-10-20";
		Date doj = sdf.parse(s1);
		String s2 = "2009-03-10";
		Date doj1 = sdf.parse(s2);
		String s3 = "2009-01-03";
		Date doj2 = sdf.parse(s3);
		String s4 = "2012-07-07";
		Date doj3 = sdf.parse(s4);
		String s5 = "2015-03-05";
		Date doj4 = sdf.parse(s5);
		Employee e1 = new Employee(1000, "Akash jv", "AKASHANKITHA@GMAIL.COM", "9008893442", doj, "DEVELOPMENT", 25, 0);
		Employee e2 = new Employee(2000, "FANTASY FLORA", "FANTASY96@GMAIL.COM", "9652489342", doj1, "INOVATION", 14, 1000);
		Employee e3 = new Employee(3000, "LEEZA ARORA", "LEEZAARORA@GMAIL.COM", "8569854756", doj2, "TESTING", 9, 1000);
		Employee e4 = new Employee(4000, "PRIYANKA NEGI", "PRIYANKANEGI@GMAIL.COM", "9856321478", doj3, "AUTOMATION", 24, 2000);
		Employee e5 = new Employee(5000, "ACHYUTH", "ACHYUTHSR@GMAIL.COM", "9562314587", doj4, "PEOPLESOFT", 90, 3000);
		// for (Employee e: res) {
		// 	switch (e.empId) {
		// 		case 1000:
		// 			assertEquals(res[0], e1);
		// 			break;
		// 		case 2000:
		// 			assertEquals(res[1000], e2);
		// 			break;				
		// 		case 2001:
		// 			assertEquals(res[1000], e3);
		// 			break;				
		// 		case 3000:
		// 			assertEquals(res[2000], e4);
		// 			break;				
		// 		case 3001:
		// 			assertEquals(res[3000], e5);
		// 			break;			
		// 		default:
		// 			fail("Unknown employee with id:" + e);	
		// 	}
		// }
	}

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException, ParseException { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = "2008-10-20";
		Date doj = sdf.parse(s1);
		String s2 = "2009-03-10";
		Date doj1 = sdf.parse(s2);
		String s3 = "2009-01-03";
		Date doj2 = sdf.parse(s3);
		String s4 = "2012-07-07";
		Date doj3 = sdf.parse(s4);
		String s5 = "2015-03-05";
		Date doj4 = sdf.parse(s5);
		Employee e1 = new Employee(1000, "Akash jv", "AKASHANKITHA@GMAIL.COM", "9008893442", doj, "DEVELOPMENT", 25, 0);
		Employee res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
		assertEquals(res, e1);
		Employee e2 = new Employee(2000, "FANTASY FLORA", "FANTASY96@GMAIL.COM", "9652489342", doj1, "INOVATION", 14, 1000);
		Employee res1 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/2000")).getBody().as(Employee.class);
		assertEquals(res1, e2);
		Employee e3 = new Employee(3000, "LEEZA ARORA", "LEEZAARORA@GMAIL.COM", "8569854756", doj2, "TESTING", 9, 1000);
		Employee res3 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/3000")).getBody().as(Employee.class);
		assertEquals(res3, e3);
		Employee e4 = new Employee(4000, "PRIYANKA NEGI", "PRIYANKANEGI@GMAIL.COM", "9856321478", doj3, "AUTOMATION", 24, 2000);
		Employee res4 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/4000")).getBody().as(Employee.class);
		assertEquals(res4, e4);
		Employee e5 = new Employee(5000, "ACHYUTH", "ACHYUTHSR@GMAIL.COM", "9562314587", doj4, "PEOPLESOFT", 90, 3000);
		Employee res5 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/5000")).getBody().as(Employee.class);
		assertEquals(res5, e5);

  }
  
  @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
	}
}
