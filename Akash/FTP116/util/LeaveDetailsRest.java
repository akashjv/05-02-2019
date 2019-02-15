package com.hexaware.FTP116.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.FTP116.model.LeaveDetails;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/leavedetails")
public class LeaveDetailsRest {

  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveDetailsList() {
    System.out.println("leave List");
    final LeaveDetails[] leavedetails = LeaveDetails.listAll();
    return leavedetails;
  }

  /**
   * Returns a specific employee's details.
   * @param id the id of the LeaveDetails.
   * @return the employee details.
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails leaveDetailsListById1(@PathParam("id") final int id) {
    final LeaveDetails ld = LeaveDetails.listById1(id);
    if (ld == null) {
      throw new NotFoundException("No such leave ID: " + id);
    }
    return ld;
  }

   /**
   * Returns a specific employee's details.
   * @param id the id of the LeaveDetails.
   * @return the employee details.
   */
  @GET
  @Path("/leavehistory/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveDetailsLeaveHistory(@PathParam("id") final int id) {
    final LeaveDetails[] ld = LeaveDetails.listAll(id);
    if (ld == null) {
      throw new NotFoundException("No such leave history: " + id);
    }
    return ld;
  }

   /**
   * Returns a specific employee's details.
   * @param id the id of the LeaveDetails.
   * @return the employee details.
   */
  @GET
  @Path("/leavepending/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveDetailsLeavePending(@PathParam("id") final int id) {
    final LeaveDetails[] ld = LeaveDetails.listPending(id);
    if (ld == null) {
      throw new NotFoundException("No such leave history: " + id);
    }
    return ld;
  }

   /**
   * Returns a specific employee's details.
   * @param empId the id of the LeaveDetails.
   * @param l the id of the LeaveDetails.
   * @throws ParseException for date.
   * @return the employee details.
   */
  @POST
  @Path("/applyleave/{empId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public final String leaveDetailsApplyLeave(@PathParam("empId") final int empId, final LeaveDetails l)
                        throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String sdate = sdf.format(l.getLeaveStartDate());
    String edate = sdf.format(l.getLeaveEndDate());
    String s = LeaveDetails.applyLeave(sdate, edate, l.getLeaveNumOfDays(), l.getLeaveReason(),
                                empId, l.getLeaveType());
    return s;
  }
    /**
   * Returns a specific employee's details.
   * @param empMgrId the id of the employee manager.
   * @param status the status of the leave.
   * @param e the object of the employee manager.
   * @return the employee details.
   * @throws ParseException for handling data.
   */
  @POST
  @Path("/approvedeny/{empMgrId}/{status}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final String approvedenyRest(@PathParam("empMgrId") final int empMgrId,
         @PathParam("status") final String status, final LeaveDetails e) throws ParseException {
    String s = LeaveDetails.approveDeny(e.getLeaveId(), empMgrId, status,
                   e.getLeaveMgrComments());
    return s;
  }
}
