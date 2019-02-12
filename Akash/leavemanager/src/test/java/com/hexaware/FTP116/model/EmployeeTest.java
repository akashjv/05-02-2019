package com.hexaware.FTP116.model;

// // import com.hexaware.FTP116.persistence.EmployeeDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.hexaware.FTP116.persistence.EmployeeDAO;

import java.text.SimpleDateFormat;

//import org.glassfish.jersey.server.ParamException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Date;
import java.text.ParseException;

// import mockit.Expectations;
// import mockit.MockUp;
// import mockit.Mocked;
//import mockit.Mock;
//import mockit.integration.junit4.JMockit;

// import java.util.ArrayList;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;


/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

/**
* setup method.
*/
  @Before
public void initInput() {

  }
/**
 * test for default constructur.
 */

  @Test
public final void testDefaultConstructor() {
    Employee e1 = null;
    assertNull(e1);
    Employee e3 = new Employee();
    assertNotNull(e3);
  }
/**
 * test for Param constructur and get/set methods of the employee.
 * @throws ParseException for Checking Date Parsing values.
 */
  @Test
  public final void testParamConstructor() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String s1 = "2018-12-20";
    Date doj = sdf.parse(s1);
    Employee e3 = new Employee(1000, "priya", "priya1@gmail.com", "8360838653", doj, "ftp", 9, 2000);
    assertEquals(1000, e3.getEmpId());
    assertEquals("priya", e3.getEmpFullName());
    assertEquals("priya1@gmail.com", e3.getEmpEmailId());
    assertEquals("8360838653", e3.getEmpMobileNo());
    assertEquals(doj, e3.getEmpDateOfJoining());
    assertEquals("ftp", e3.getEmpDepartment());
    assertEquals(9, e3.getEmpLeaveBalance());
    assertEquals(2000, e3.getEmpManagerId());
    Employee e1 = new Employee();
    e1.setEmpId(2000);
    assertEquals(2000, e1.getEmpId());
    e1.setEmpFullName("fantasy");
    assertEquals("fantasy", e1.getEmpFullName());
    e1.setEmpEmailId("fantasyflora@gmail.com");
    assertEquals("fantasyflora@gmail.com", e1.getEmpEmailId());
    e1.setEmpMobileNo("9566692677");
    assertEquals("9566692677", e1.getEmpMobileNo());
    e1.setEmpDateOfJoining(doj);
    assertEquals(doj, e1.getEmpDateOfJoining());
    e1.setEmpDepartment("FTP");
    assertEquals("FTP", e1.getEmpDepartment());
    e1.setEmpLeaveBalance(1);
    assertEquals(1, e1.getEmpLeaveBalance());
    e1.setEmpManagerId(123);
    assertEquals(123, e1.getEmpManagerId());
    Employee e2 = new Employee(1, "leeza", "leeza@gmail.com", "1234567899", doj, "FTP", 12, 123);
    Employee e4 = new Employee(1, "leeza", "leeza@gmail.com", "1234567899", doj, "FTP", 12, 123);
    assertEquals(e2.hashCode(), e4.hashCode());
    // String res = "empId:1 empFullName:leeza empEmailId:leeza@gmail.com"
    //             + " empMobileNo:1234567899 empDateOfJoining:2018-12-20"
    //             + " empDepartment:FTP empLeaveBalance:12 empManagerId:123";
    Employee e5 = new Employee(1, "leeza", "leeza@gmail.com", "1234567899", doj, "FTP", 12, 123);
    String res1 = "empId:1 empFullName:leeza empMobileNo:1234567899"
                  + " empDateOfJoining:2018-12-20 empLeaveBalance:12 empManagerId:123"
                  + " empEmailId:leeza@gmail.com empDepartment:FTP";
    assertEquals(res1, e5.toString());
    assertEquals(e2, e4);
    assertNotEquals(e1, e5);
    Employee e6 = null;
    assertNotEquals(e6, e1);
    Employee e7 = null;
    assertNotEquals(e1, e7);
    LeaveDetails ld = new LeaveDetails();
    assertNotEquals(e4, ld);
    EmployeeDAO edao = Employee.dao();
    assertNotNull(edao);
  }


  // /**
  //  * Tests the equals/hashcode methods of the employee class.
  //  */
  // @Test
  // public final void testEmployee() {
  //   Employee e100 = new Employee(100);
  //   Employee e101 = new Employee(101);
  //   assertNotEquals(e100, null);
  //   assertNotEquals(e100, new Integer(100));
  //   assertEquals(e100, new Employee(100));
  //   assertNotEquals(e101, new Employee(100));
  //   assertEquals(e100.hashCode(), new Employee(100).hashCode());
  //   assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
  //   e101.setEmpId(100);
  //   assertEquals(e101, new Employee(100));
  // }


  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list();
        result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  // /**
  //  * Tests that a list with some employees is handled correctly.
  //  * @param dao mocking the dao class
  //  */
  // @Test
  // public final void testListAllSome(@Mocked final EmployeeDAO dao) {
  //   new Expectations() {
  //     {
  //       ArrayList<Employee> es = new ArrayList<Employee>();
  //       es.add(new Employee(1));
  //       es.add(new Employee(10));
  //       es.add(new Employee(100));
  //       dao.list(); result = es;
  //     }
  //   };
  //   new MockUp<Employee>() {
  //     @Mock
  //     EmployeeDAO dao() {
  //       return dao;
  //     }
  //   };
  //   Employee[] es = Employee.listAll();
  //   assertEquals(3, es.length);
  //   assertEquals(new Employee(1), es[0]);
  //   assertEquals(new Employee(10), es[1]);
  //   assertEquals(new Employee(100), es[2]);
  // }

  //   /**
  //  * Tests that a fetch of a specific employee works correctly.
  //  * @param dao mocking the dao class
  //  */
  // @Test
  // public final void testListById(@Mocked final EmployeeDAO dao) {
  //   final Employee e100 = new Employee(100);
  //   new Expectations() {
  //     {
  //       dao.find(100); result = e100;
  //       dao.find(-1); result = null;
  //     }
  //   };
  //   new MockUp<Employee>() {
  //     @Mock
  //     EmployeeDAO dao() {
  //       return dao;
  //     }
  //   };
  //   Employee e = Employee.listById(100);
  //   assertEquals(e100, e);

  //   e = Employee.listById(-1);
  //   assertNull(e);
  // }
}
