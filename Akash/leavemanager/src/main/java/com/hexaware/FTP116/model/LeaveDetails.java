package com.hexaware.FTP116.model;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.List;
import java.util.Date;


import com.hexaware.FTP116.persistence.LeaveDetailsDAO;
import com.hexaware.FTP116.persistence.DbConnection;
import com.hexaware.FTP116.persistence.EmployeeDAO;


import java.text.ParseException;


/**
 * LeaveDetails class to store Leave Details of employee.
 *
 * @author hexaware.
 */
public class LeaveDetails {
  /**
   * leaveEmpId to store employee id.
   */
  private int leaveEmpId;
  /**
   * leaveId to store employee leave.
   */
  private int leaveId;
  /**
   * leavetype to store employee leavetype.
   */
  private LeaveType leaveType;
  /**
   * LeaveStartDate to store employee Leave Start Date.
   */
  private Date leaveStartDate;
  /**
   * LeaveEndDate to Store employee leave End date.
   */
  private Date leaveEndDate;
  /**
   * LeaveAppliedOn to Store employee leaved applie date.
   */
  private Date leaveAppliedOn;
  /**
   * leaveReason to store employee leave Reason.
   */
  private String leaveReason;
  /**
   * LeaveNumOfDays to store employee applied for Num of days.
   */
  private int leaveNumOfDays;
  /**
   * leaStatus to store employee status of applied leave.
   */
  private LeaveStatus leaveStatus;
  /**
   * LeaveMgrComments to store managers comments on leave.
   */
  private String leaveMgrComments;

  @Override
  public final int hashCode() {
    return Objects.hash(leaveEmpId, leaveId, leaveType, leaveStartDate, leaveEndDate, leaveAppliedOn, leaveReason,
                        leaveNumOfDays, leaveStatus, leaveMgrComments);
  }

  @Override
  public final String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String s1 = sdf.format(leaveStartDate);
    String e1 = sdf.format(leaveEndDate);
    String a1 = sdf.format(leaveAppliedOn);
    return "leaveEmpId:" + leaveEmpId + " leaveId:" + leaveId + " leaveType:" + leaveType
           + " leaveStartDate:" + s1 + " leaveEndDate:" + e1 + " leaveAppliedOn:"
           + a1 + " leaveReason:" + leaveReason + " leaveNumOfDays:" + leaveNumOfDays
           + " leaveStatus:" + leaveStatus + " leaveMgrComments:" + leaveMgrComments;
  }
  // @Override
  // public final String toString() {
  //   return " leaveEmpId " + leaveEmpId + " leaveId " + leaveId + " leaveType " + leaveType + " leaveStartDate "
  //     + leaveStartDate + " leaveEndDate " + leaveEndDate + " leaveAppliedOn " + leaveAppliedOn + " leaveReason "
  //     + leaveReason + " leaveNumOfDays "
  //     + leaveNumOfDays + " leaveStatus " + leaveStatus + " leaveMgrComments " + leaveMgrComments;
  // }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails lev = (LeaveDetails) obj;
    if (Objects.equals(leaveEmpId, lev.leaveEmpId)
        && Objects.equals(leaveId, lev.leaveId)
        && Objects.equals(leaveType, lev.leaveType)
        && Objects.equals(leaveStartDate, lev.leaveStartDate)
        && Objects.equals(leaveEndDate, lev.leaveEndDate)
        && Objects.equals(leaveAppliedOn, lev.leaveAppliedOn)
        && Objects.equals(leaveReason, lev.leaveReason)
        && Objects.equals(leaveNumOfDays, lev.leaveNumOfDays)
        && Objects.equals(leaveStatus, lev.leaveStatus)
        && Objects.equals(leaveMgrComments, lev.leaveMgrComments)) {
      return true;
    }
    return false;
  }

  /**
  * default Constructor.
   */
  public LeaveDetails() {
  }

  /**
   * @param argLeaveEmpId to initialize employee id.
   * @param argLeaveId to initialize Leave Id .
   * @param argLeaveType to initialize Leave Type.
   * @param argLeaveStartDate to initialize Start Date Of Leave.
   * @param argLeaveEndDate to initialize End date of Leave.
   * @param argLeaveAppliedOn to initialize Applied on.
   * @param argLeaveReason to initialize Leave  Reason.
   * @param argLeaveNumOfDays to initialize Num of days Leave applied.
   * @param argLeaveStatus to initialize Status of applied Leave.
   * @param argLeaveMgrComments to initialize Manager Comments.
   */
  public LeaveDetails(final int argLeaveEmpId, final int argLeaveId, final LeaveType argLeaveType,
                      final Date argLeaveStartDate, final Date argLeaveEndDate, final Date argLeaveAppliedOn,
                      final String argLeaveReason, final int argLeaveNumOfDays, final LeaveStatus argLeaveStatus,
                      final String argLeaveMgrComments) {
    this.leaveEmpId = argLeaveEmpId;
    this.leaveId = argLeaveId;
    this.leaveType = argLeaveType;
    this.leaveStartDate = argLeaveStartDate;
    this.leaveEndDate = argLeaveEndDate;
    this.leaveAppliedOn = argLeaveAppliedOn;
    this.leaveReason = argLeaveReason;
    this.leaveNumOfDays = argLeaveNumOfDays;
    this.leaveStatus = argLeaveStatus;
    this.leaveMgrComments = argLeaveMgrComments;

  }
  /**
   * Gets the Em.
   * @return this Employee's ID.
   */
  public final int getLeaveEmpId() {
    return leaveEmpId;
  }
  /**
   * @param argLeaveEmpId to set Leave id.
   */
  public final void setLeaveEmpId(final int argLeaveEmpId) {
    this.leaveEmpId = argLeaveEmpId;
  }
  /**
   * Gets the LeaveID.
   * @return this Leave ID.
   */
  public final int getLeaveId() {
    return leaveId;
  }
  /**
   * @param argLeaveId to set Leave id.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }
  /**
   * Gets the LeaveTYpe.
   * @return this Employee's ID.
   */
  public final LeaveType getLeaveType() {
    return leaveType;
  }
  /**
   * @param argLeaveType to set Leave Type.
   */
  public final void setLeaveType(final LeaveType argLeaveType) {
    this.leaveType = argLeaveType;
  }
  /**
   * Gets the Leave Start Date.
   * @return this Leave Start Date.
   */
  public final Date getLeaveStartDate() {
    return leaveStartDate;
  }
  /**
   * @param argLeaveStartDate to set Leave StartDate.
   */
  public final void setLeaveStartDate(final Date argLeaveStartDate) {
    this.leaveStartDate = argLeaveStartDate;
  }
  /**
   * Gets the Leave End Date.
   * @return this Leave End Date.
   */
  public final Date getLeaveEndDate() {
    return leaveEndDate;
  }
  /**
   * @param argLeaveEndDate to set Leave EndDate.
   */
  public final void setLeaveEndDate(final Date argLeaveEndDate) {
    this.leaveEndDate = argLeaveEndDate;
  }
  /**
   * Gets the Leave Applied Date.
   * @return this Leave Applied Date.
   */
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }
  /**
   * @param argLeaveAppliedOn to set Leave Applied On.
   */
  public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }
  /**
   * Gets the Leave Reason.
   * @return this Leave Reason.
   */
  public final String getLeaveReason() {
    return leaveReason;
  }
  /**
   * @param argLeaveReason to set Leave Reason.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }
  /**
   * Gets the Num of Leaves Applied.
   * @return this Num Of leaves Applied.
   */
  public final int getLeaveNumOfDays() {
    return leaveNumOfDays;
  }
  /**
   * @param argLeaveNumOfDays to set Num of Days.
   */
  public final void setLeaveNumOfDays(final int argLeaveNumOfDays) {
    this.leaveNumOfDays = argLeaveNumOfDays;
  }
  /**
   * Gets the Leave Status.
   * @return this Leave Status.
   */
  public final LeaveStatus getLeaveStatus() {
    return leaveStatus;
  }
  /**
   * @param argLeaveStatus to set Leave Status.
   */
  public final void setLeaveStatus(final LeaveStatus argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }
  /**
   * Gets the Manager Comments on Leave.
   * @return this Manager Comments on Leave.
   */
  public final String getLeaveMgrComments() {
    return leaveMgrComments;
  }
  /**
   * @param argLeaveMgrComments to set Leave Manager Comments.
   */
  public final void setLeaveMgrComments(final String argLeaveMgrComments) {
    this.leaveMgrComments = argLeaveMgrComments;
  }
  /**
   * the dao for Employee.
   * @return the EmployeeDAO class objects.
   */
  public static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }
  /**
   * the dao for LeaveDetails.
   * @return this LeaveDetailsDAO Class objects.
   */
  public static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }
  /**
   * list all LeaveHistory details.
   * @param empId id to get Leave details.
   * @return all Leave details.
   */
  public static LeaveDetails[] listAll(final int empId) {
    List<LeaveDetails> es = dao().leaveHistory(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
   * list all LeavePending details.
   * @param empId id to get Leave details.
   * @return all Leave details.
   */
  public static LeaveDetails[] listPending(final int empId) {
    List<LeaveDetails> es = dao().pending(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
   * list employee details by id.
   * @param argLeaveId id to get employee details.
   * @return LeaveDetails.
   */
  public static LeaveDetails listById1(final int argLeaveId) {
    return dao().listById1(argLeaveId);
  }
  /**
 * @param argLeaveId to set leave id.
 * @param argEmpManagerId to set MangerId.
 * @param argLeaveStatus to set Approve or Deny.
 * @param argLeaveMgrComments to set Manager Response.
 * @return leave Applied Status.
 */
  public static String approveDeny(final int argLeaveId,
      final int argEmpManagerId,
      final String argLeaveStatus,
      final String argLeaveMgrComments) {
    String res = "";
    LeaveDetails ld = LeaveDetails.listById1(argLeaveId);
    if (ld != null) {
      int noDays = ld.getLeaveNumOfDays();
      int empId = ld.getLeaveEmpId();
      Employee ed = Employee.listById(empId);
      int leavAvail = ed.getEmpLeaveBalance();
      leavAvail = leavAvail + noDays;
      int empManagerId = ed.getEmpManagerId();
      String leaveStatus = "";
      if (empManagerId != argEmpManagerId) {
        res = "you are unauthorised to approve the Leave";
      } else {
        if (argLeaveStatus.equals("YES")) {
          res = "Leave Approved Successfully...";
          leaveStatus = "APPROVED";
          dao().approveOrDeny(argLeaveId, leaveStatus, argLeaveMgrComments);
        } else {
          res = "Leave Rejected";
          leaveStatus = "DENIED";
          dao().approveOrDeny(argLeaveId, leaveStatus, argLeaveMgrComments);
          edao().increment(empId, leavAvail);
        }
      }
    } else {
      res = "Leave id not found";
    }

    return res;
  }
/**
 * @param argEmpId to set employee id.
 * @param argLeaveStartDate to set leave start date.
 * @param argLeaveEndDate to set leave end date.
 * @param argLeaveNumOfDays to set number of leave days.
 * @param argLeaveType to set leave type.
 * @param argLeaveReason to set the reason.
 * @return string from apply leave.
 * @throws ParseException when no values.
 */
  public static String applyLeave(final String argLeaveStartDate,
                                  final String argLeaveEndDate,
                                  final int argLeaveNumOfDays,
                                  final String argLeaveReason,
                                  final int argEmpId,
                                  final LeaveType argLeaveType) throws ParseException {
    Date cur = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String appliedOn = sdf.format(cur);
    Date sdate = sdf.parse(argLeaveStartDate);
    Date edate = sdf.parse(argLeaveEndDate);
    Date cdate = sdf.parse(appliedOn);
    long diff = edate.getTime() - sdate.getTime();
    long noDays = diff / (1000 * 60 * 60 * 24);
    int count = dao().count(argEmpId, argLeaveStartDate, argLeaveEndDate);
    System.out.println("applied count status " + count);
    int days = (int) noDays;
    String res = "";
    Employee e = Employee.listById(argEmpId);
    if (e != null) {
      int leavAvail = e.getEmpLeaveBalance();
      int empMgrId = e.getEmpManagerId();
      int dif = leavAvail - argLeaveNumOfDays;
      days = days + 1;
      System.out.println("Days " + days);
      if (days <= 0) {
        res = "EndDate must be greater than Startdate..";
      } else if (dif < 0) {
        res = "insufficient leave balance..";
      } else if (argLeaveNumOfDays != days) {
        res = "Enter correct number of days as " + days;
      } else if (sdate.compareTo(cdate) < 0) {
        res = "startdate is less than current date";
      } else if (count == 1) {
        res = "already applied on given dates";
      } else if (empMgrId == 0) {
        LeaveStatus leaveStatus = LeaveStatus.APPROVED;
        dao().insert(argLeaveStartDate, argLeaveEndDate,
                     argLeaveNumOfDays, appliedOn, argLeaveReason, argEmpId, leaveStatus, argLeaveType);
        leavAvail = leavAvail - days;
        edao().decrement(leavAvail, argEmpId);
        res = "leave AUTOAPPROVED";
      } else {
        LeaveStatus leaveStatus = LeaveStatus.PENDING;
        dao().insert(argLeaveStartDate, argLeaveEndDate,
                     argLeaveNumOfDays, appliedOn, argLeaveReason, argEmpId, leaveStatus, argLeaveType);
        leavAvail = leavAvail - days;
        edao().decrement(leavAvail, argEmpId);
        res = "leave Applied successfully...";
      }
    } else {
      res = "Employee id not found";
    }
    return res;
  }
}

