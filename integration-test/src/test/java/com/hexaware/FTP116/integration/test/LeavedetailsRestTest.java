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

public class LeavedetailsRestTest {

	@Test
	public void testLeaveDetailsList() throws AssertionError, URISyntaxException, ParseException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails")).getBody().as(LeaveDetails[].class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = "2019-03-08";
		Date sdate= sdf.parse(s1);
		String s2 = "2019-03-08";
		Date edate= sdf.parse(s2);
		String s3 = "2019-02-14";
		Date adate= sdf.parse(s3);
		
		LeaveDetails l1 = new LeaveDetails(1000, 1, LeaveType.PL, sdate, edate, adate, "kjghdk", 1, LeaveStatus.APPROVED, "uawhyeuip");
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
	public void testLeaveDetailsById() throws AssertionError, URISyntaxException, ParseException { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = "2019-03-08";
		Date sdate= sdf.parse(s1);
		String s2 = "2019-03-08";
		Date edate= sdf.parse(s2);
		String s3 = "2019-02-14";
		Date adate= sdf.parse(s3);
		LeaveDetails l1 = new LeaveDetails(1000, 1,  LeaveType.PL, sdate, edate, adate, "kjghdk", 1, LeaveStatus.APPROVED, "uawhyeuip");
		 LeaveDetails res = given().accept(ContentType.JSON).when()
			.get(CommonUtil.getURI("/api/leavedetails/1")).getBody().as(LeaveDetails.class);
		assertEquals(res, l1);
		
  }
  
  @Test
	public void testLeaveDetailsById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/9999")).then().assertThat().statusCode(404);
    }
    @Test
    public void testApplyLeave() throws AssertionError, URISyntaxException {
        String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveNumOfDays\":\"1\",\"leaveStartDate\":\"2019-12-09\",\"leaveEndDate\":\"2019-12-08\",\"leaveType\":\"EL\",\"leaveReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/3000")).getBody().asString();
        assertEquals("EndDate must be greater than Startdate..", res1);

        String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2019-12-09\",\"leaveEndDate\":\"2019-12-09\",\"leaveType\":\"EL\",\"leaveNumOfDays\":\"0\",\"leaveReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/3000")).getBody().asString();
        assertEquals("Enter correct number of days as 1", res2);

        String res3=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2019-03-09\",\"leaveEndDate\":\"2019-03-09\",\"leaveType\":\"EL\",\"leaveNumOfDays\":\"1\",\"leaveReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/3000")).getBody().asString();
        assertEquals("its a weekend", res3);

        String res4=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveStartDate\":\"2019-03-07\",\"leaveEndDate\":\"2019-03-07\",\"leaveType\":\"EL\",\"leaveNumOfDays\":\"1\",\"leaveReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/3000")).getBody().asString();
        assertEquals("startdate is less than current date", res4);
    }

    @Test
	public void testPendingLeaves() throws AssertionError, URISyntaxException,ParseException { 
              
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
          final String s1 = "2019-02-26";
    final Date s = sdf.parse(s1);
    final String s2 = "2019-02-26";
    final Date e = sdf.parse(s2);
    final String s3 = "2019-02-25";
    final Date l = sdf.parse(s3);
           LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/listPending/1000")).getBody().as(LeaveDetails[].class);
           LeaveDetails l2 = new LeaveDetails(34, 2000, 1, s, e, LeaveType.EL, LeaveStatus.PENDING, "home", l, "null");
           assertEquals(res[0].getLeaId(), l2.getLeaId());
    }
}
