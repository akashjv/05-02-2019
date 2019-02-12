package com.hexaware.FTP116.model;

//import com.hexaware.FTP116.model.LeaveDetails;

import com.hexaware.FTP116.persistence.LeaveDetailsDAO;
import com.hexaware.FTP116.persistence.EmployeeDAO;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.text.ParseException;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import java.util.Date;


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
public class LeaveDetailsTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
/**
 *test for default constructor.
 */
  @Test
  public final void testDefaultConstructor() {
    LeaveDetails l1 = null;
    assertNull(l1);
    LeaveDetails l2 = new LeaveDetails();
    assertNotNull(l2);
  }

/**
 *test for Param constructor.
 *@throws ParseException for checking date parsing values.
 */
  @Test
  public final void testParamConstructor() throws ParseException {
    SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
    String s1 = "2019-02-07";
    SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd");
    String s2 = "2019-02-07";
    SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY-MM-dd");
    String s3 =  "2019-02-06";
    Date sdate = sdf1.parse(s1);
    Date edate = sdf2.parse(s2);
    Date adate = sdf3.parse(s3);
    LeaveDetails l3 = new LeaveDetails(1000, 1, LeaveType.ML, sdate, edate, adate, "sick", 1,
        LeaveStatus.PENDING, "get well soon");
    assertEquals(1000, l3.getLeaveEmpId());
    assertEquals(1, l3.getLeaveId());
    assertEquals(LeaveType.ML, l3.getLeaveType());
    assertEquals(sdate, l3.getLeaveStartDate());
    assertEquals(edate, l3.getLeaveEndDate());
    assertEquals(adate, l3.getLeaveAppliedOn());
    assertEquals("sick", l3.getLeaveReason());
    assertEquals(1, l3.getLeaveNumOfDays());
    assertEquals(LeaveStatus.PENDING, l3.getLeaveStatus());
    assertEquals("get well soon", l3.getLeaveMgrComments());
    LeaveDetails l1 = new LeaveDetails();
    l1.setLeaveEmpId(2000);
    assertEquals(2000, l1.getLeaveEmpId());
    l1.setLeaveId(2);
    assertEquals(2, l1.getLeaveId());
    l1.setLeaveType(LeaveType.PL);
    assertEquals(LeaveType.PL, l1.getLeaveType());
    l1.setLeaveStartDate(sdate);
    assertEquals(sdate, l1.getLeaveStartDate());
    l1.setLeaveEndDate(edate);
    assertEquals(edate, l1.getLeaveEndDate());
    l1.setLeaveAppliedOn(adate);
    assertEquals(adate, l1.getLeaveAppliedOn());
    l1.setLeaveReason("home town");
    assertEquals("home town", l1.getLeaveReason());
    l1.setLeaveNumOfDays(1);
    assertEquals(1, l1.getLeaveNumOfDays());
    l1.setLeaveStatus(LeaveStatus.APPROVED);
    assertEquals(LeaveStatus.APPROVED, l1.getLeaveStatus());
    l1.setLeaveMgrComments("Enjoy your journey");
    assertEquals("Enjoy your journey", l1.getLeaveMgrComments());

    LeaveDetails l2 = new LeaveDetails(2000, 3, LeaveType.ML, sdate, edate, adate, "sick", 1,
        LeaveStatus.APPROVED, "get well soon");
    LeaveDetails l4 =  new LeaveDetails(2000, 3, LeaveType.ML, sdate, edate, adate, "sick", 1,
        LeaveStatus.APPROVED, "get well soon");
    assertEquals(l2.hashCode(), l4.hashCode());
    String res = "leaveEmpId:2000 leaveId:3 leaveType:ML leaveStartDate:2018-12-30"
        + " leaveEndDate:2018-12-30 leaveAppliedOn:2018-12-30 leaveReason:sick leaveNumOfDays:1"
        + " leaveStatus:APPROVED leaveMgrComments:get well soon";
    assertEquals(res, l2.toString());
    LeaveDetailsDAO ldo = LeaveDetails.dao();
    assertNotNull(ldo);
    EmployeeDAO ledo = LeaveDetails.edao();
    assertNotNull(ledo);
    assertEquals(l2, l4);
    assertNotEquals(l2, l1);
    Employee e7 = new Employee();
    assertNotEquals(l2, e7);
    LeaveDetails l9 = null;
    LeaveDetails l8 = new LeaveDetails();
    //assertNull(l9);
    assertNotEquals(l8, l9);



    LeaveDetails l5 = null;
    assertNotEquals(l2, l5);
    Employee em = new Employee();
    assertNotEquals(l2, em);
    assertEquals(l2, l4);
  }
  /**
   *@param dao leave details pending.
   */
  @Test
public final void testPending(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        dao.pending(100);
        result = new ArrayList<LeaveDetails>();
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
    LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es = LeaveDetails.listPending(100);
    assertEquals(0, es.length);
  }
  /**
   *@param dao for leaveDetails.
   *@throws ParseException for null values.
   */
  @Test
        public final void testListApplyPending(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    new Expectations() {
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      }
    };
  }
/**
 *@throws ParseException when no values.
 *@param ldao for listAval.
 */
  @Test
  public final void listAval(@Mocked final LeaveDetailsDAO ldao)throws ParseException {
    new Expectations() {
          {
            ArrayList<LeaveDetails> ls1 = new ArrayList<LeaveDetails>();
            ArrayList<LeaveDetails> ls2 = new ArrayList<LeaveDetails>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String s0 = "2019-02-02";
            String s1 = "2019-02-13";
            String s2 = "2019-02-20";
            Date sdoj = sdf.parse(s0);
            Date sdoj1 = sdf.parse(s1);
            Date sdoj2 = sdf.parse(s2);
            Date sdoj3 = sdf.parse(s1);
            Date sdoj4 = sdf.parse(s0);
            String e0 = "2019-02-03";
            String e1 = "2019-02-13";
            String e2 = "2019-02-22";
            Date edoj = sdf.parse(e0);
            Date edoj1 = sdf.parse(e1);
            Date edoj2 = sdf.parse(e2);
            Date edoj3 = sdf.parse(e1);
            Date edoj4 = sdf.parse(e0);

            LeaveType lt = LeaveType.EL;
            LeaveStatus s = LeaveStatus.PENDING;
            ls1.add(new LeaveDetails(10, 4, lt, sdoj, edoj, sdoj, "Sick", 2, s, "tc"));
            ls1.add(new LeaveDetails(12, 5, lt, sdoj1, edoj1, sdoj1, "Sick", 1, s, "tc"));
            ls1.add(new LeaveDetails(15, 6, lt, sdoj2, edoj2, sdoj2, "Sick", 3, s, "tc"));
            ls1.add(new LeaveDetails(19, 7, lt, sdoj3, edoj3, sdoj3, "Sick", 1, s, "tc"));
            ls1.add(new LeaveDetails(17, 1, lt, sdoj4, edoj4, sdoj4, "Sick", 2, s, "tc"));
            ldao.leaveHistory(1);
            result = ls1;
            ldao.leaveHistory(2);
            result = ls2;
      }
      };
    new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
            return ldao;
        }
    };
    LeaveDetails[] lsr1 = LeaveDetails.listAll(1);
    assertNotEquals(3, lsr1.length);
    LeaveDetails[] lsr2 = LeaveDetails.listAll(2);
    assertNotEquals(2, lsr2.length);
  }
/**
 *@param edao for EmployeeDAO.
 *@param ldao for LeaveDetailsDAO.
 *@throws ParseException for converting date to string.
 */
  @Test
  public final void testApplyLeave(@Mocked final EmployeeDAO edao, @Mocked final LeaveDetailsDAO ldao)
  throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "1998-12-12";
    final Date doj = sdf.parse(s1);
    final Date today = new Date();
    final String strToday = sdf.format(today);
    new Expectations() {
          {
            ldao.count(100, "2019-04-16", "2019-04-17"); result = 1;
            //ldao.count(100, "2019-04-30", "2019-04-30"); result = 0;
            ldao.count(200, "2019-04-30", "2019-04-30"); result = 0;
          }
      };
    new Expectations() {
          {
            ldao.insert("2019-04-20", "2019-04-21", 2, strToday, "sick", 100, LeaveStatus.APPROVED, LeaveType.ML);
            //ldao.insert("2019-04-30", "2019-04-30", 1, "2019-02-08", "sick", 200, LeaveStatus.APPROVED, LeaveType.ML);
          }
      };
    new Expectations() {
          {
            Employee e = new Employee(100, "fantasy", "fantasy@gmail", "9566692677", doj, "Ftp", 12, 0);
            Employee e2 = new Employee(200, "fantasy", "fantasy@gmail", "9566692677", doj, "Ftp", 12, 100);
            edao.find(100); result = e;
            edao.find(200); result = e2;
            edao.find(500); result = null;
      }
      };
    new MockUp<LeaveDetails>() {
          @Mock
          LeaveDetailsDAO dao() {
        return ldao;
          }
      };
    new MockUp<Employee>() {
          @Mock
          EmployeeDAO dao() {
        return edao;
          }
      };
    String res1 = LeaveDetails.applyLeave("2019-04-21", "2019-04-20", 2, "sick", 200, LeaveType.ML);
    assertEquals(res1, "EndDate must be greater than Startdate..");
    String res2 = LeaveDetails.applyLeave("2019-04-20", "2019-04-21", 2, "sick", 100, LeaveType.ML);
    assertEquals(res2, "leave AUTOAPPROVED");
    String res3 = LeaveDetails.applyLeave("2019-04-16", "2019-04-17", 2, "sick", 100, LeaveType.ML);
    assertEquals(res3, "already applied on given dates");
    String res4 = LeaveDetails.applyLeave("2019-04-28", "2019-04-30", 2, "sick", 100, LeaveType.ML);
    assertEquals(res4, "Enter correct number of days as 3");
    String res5 = LeaveDetails.applyLeave("2019-04-01", "2019-05-14", 15, "sick", 100, LeaveType.ML);
    assertEquals(res5, "insufficient leave balance..");
    String res6 = LeaveDetails.applyLeave("2019-05-30", "2019-05-30", 1, "sick", 500, LeaveType.ML);
    assertEquals(res6, "Employee id not found");
    String res7 = LeaveDetails.applyLeave("2019-04-30", "2019-04-30", 1, "sick", 200, LeaveType.ML);
    assertEquals(res7, "leave Applied successfully...");
    String res8 = LeaveDetails.applyLeave("2019-02-04", "2019-02-07", 4, "sick", 200, LeaveType.ML);
    assertEquals(res8, "startdate is less than current date");
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param edao EmployeeDAO mocking the dao class.
   * @param ldao LeaveDetailsDAO mocking the dao class.
   * @throws ParseException for null values.
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO edao, @Mocked final LeaveDetailsDAO ldao)
                                    throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s0 = "2019-05-02";
    final String s1 = "2019-05-05";
    final String s2 = "2019-05-02";
    final Date sdoj = sdf.parse(s0);
    final Date sdoj1 = sdf.parse(s1);
    final Date sdoj2 = sdf.parse(s2);
    final LeaveDetails l1 = new LeaveDetails(2, 1, LeaveType.EL, sdoj, sdoj1, sdoj2, "sick", 2, LeaveStatus.APPROVED,
                                      "Tension");
    final Employee e1 = new Employee(2, "Priyanka K", "priyanka@gmail.com", "1234567899", sdoj,
                               "FTP", 10, 1);
    new Expectations() {
      {
        ldao.listById1(1); result = l1;
        ldao.listById1(20); result = null;
      }
    };
    new Expectations() {
      {
        edao.find(2); result = e1;
      }
    };
    new Expectations() {
      {
        ldao.approveOrDeny(1, "APPROVED", "faad");
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return ldao;
      }
    };
    String res1 = LeaveDetails.approveDeny(1, 1, "YES", "faad");
    assertEquals(res1, "Leave Approved Successfully...");
    String res2 = LeaveDetails.approveDeny(1, 1, "NO", "faad");
    assertEquals(res2, "Leave Rejected");
    String res3 = LeaveDetails.approveDeny(20, 1, "NO", "faad");
    assertEquals(res3, "Leave id not found");
    String res4 = LeaveDetails.approveDeny(1, 3, "NO", "faad");
    assertEquals(res4, "you are unauthorised to approve the Leave");
  }

}


