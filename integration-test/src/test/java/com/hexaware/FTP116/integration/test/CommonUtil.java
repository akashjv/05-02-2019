package com.hexaware.FTP116.integration.test;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "FTP116");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {
   /**
   * empId to store employee id.
   * empFullName to store employee name.
   * empEmailId to store employee email id.
   * empMobileNo to store employee moblie no.
   * empdateOfJoining to store employee date of joining.
   * empDepartment to store employee department;
   * empLeaveBalance to store the employ leave balance.
   * empManagerId to store manager id
   */
  private int empId;
  private String empFullName;
  private String empMobileNo;
  private Date empDateOfJoining;
  private int empLeaveBalance;
  private int empManagerId;
  private String empEmailId;
  private String empDepartment;
/**
 * Default Constructer.
 */
  public Employee() {

  }


  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    Employee emp = (Employee) obj;
    String d1 = sdf.format(emp.empDateOfJoining);
    String d2 = sdf.format(empDateOfJoining);
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empFullName, emp.empFullName)
        && Objects.equals(empMobileNo, emp.empMobileNo)
        && Objects.equals(d1, d2)
        && Objects.equals(empLeaveBalance, emp.empLeaveBalance)
        && Objects.equals(empManagerId, emp.empManagerId)
        && Objects.equals(empEmailId, emp.empEmailId)
        && Objects.equals(empDepartment, emp.empDepartment)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empFullName, empMobileNo, empDateOfJoining, empLeaveBalance, empManagerId,
                        empEmailId, empDepartment);
  }

   

    /**
   * @param argEmpId to initialize employee id.
   * @param argEmpFullName to initialize employee fullname.
   * @param argEmpEmailId to initialize employee email id.
   * @param argEmpMobileNo to initialize employee mobile no.
   * @param argEmpDateOfJoining to initialize employee date of joining.
   * @param argEmpDepartment to initialize employee department.
   * @param argEmpLeaveBalance to initialize employee leave balance.
   * @param argEmpManagerId to initialize employee manager id.
   */
  public Employee(final int argEmpId, final String argEmpFullName, final String argEmpEmailId,
  final String argEmpMobileNo, final Date argEmpDateOfJoining, final String argEmpDepartment,
  final int argEmpLeaveBalance, final int argEmpManagerId) {
this.empId = argEmpId;
this.empFullName = argEmpFullName;
this.empEmailId = argEmpEmailId;
this.empMobileNo = argEmpMobileNo;
this.empDateOfJoining = argEmpDateOfJoining;
this.empDepartment = argEmpDepartment;
this.empLeaveBalance = argEmpLeaveBalance;
this.empManagerId = argEmpManagerId;
}

/**
* Gets the EmployeeId.
* @return this Employee's ID.
*/
public final int getEmpId() {
return empId;
}
/**
*
* @param argEmpId to set employee id.
*/
public final void setEmpId(final int argEmpId) {
this.empId = argEmpId;
}
/**
* Gets the Employee Name.
* @return this Employee's name.
*/
public final String getEmpFullName() {
return empFullName;
}
/**
* @param argEmpFullName to set employee name.
*/
public final void setEmpFullName(final String argEmpFullName) {
this.empFullName = argEmpFullName;
}
/**
* Gets the Employee email id.
* @return this Employee's email id.
*/
public final String getEmpEmailId() {
return empEmailId;
}

/**
* @param argEmpEmailId to set employee email id.
*/
public final void setEmpEmailId(final String argEmpEmailId) {
this.empEmailId = argEmpEmailId;
}
/**
* gets the employee mobile no.
* @return this employee's mobile no.
*/
public final String getEmpMobileNo() {
return empMobileNo;
}
/**
* @param argEmpMobileNo to set employee mobile no.
*/
public final void setEmpMobileNo(final String argEmpMobileNo) {
this.empMobileNo = argEmpMobileNo;
}
/**
* gets the employee date of joining.
* @return this employee's date of joining.
*/
public final Date getEmpDateOfJoining() {
return empDateOfJoining;
}
/**
* @param argEmpDateOfJoining to set employee date of joining.
*/
public final void setEmpDateOfJoining(final Date argEmpDateOfJoining) {
this.empDateOfJoining = argEmpDateOfJoining;
}
/**
* gets the employee department.
* @return this employee's department.
*/
public final String getEmpDepartment() {
return empDepartment;
}
/**
* @param argEmpDepartment to set employee department.
*/
public final void setEmpDepartment(final String argEmpDepartment) {
this.empDepartment = argEmpDepartment;
}
/**
* gets the employee leave details.
* @return this employee's leave details.
*/
public final int getEmpLeaveBalance() {
return empLeaveBalance;
}
/**
* @param argEmpLeaveBalance to set employee leave details.
*/
public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
this.empLeaveBalance = argEmpLeaveBalance;
}
/**
* gets the employee manager id.
* @return this employee's manager id.
*/
public final int getEmpManagerId() {
return empManagerId;
}
/**
* @param argEmpManagerId to set employee's manager id.
*/
public final void setEmpManagerId(final int argEmpManagerId) {
this.empManagerId = argEmpManagerId;
}
public String toString() {
  try {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    return ow.writeValueAsString(this);
  } catch(Exception e) {
    throw new RuntimeException(e);
  }
}


}


enum LeaveType {
  /**
  * LeaveType to store EL.
  */
  EL,

  /**
  * LeaveType to store PL.
  */
  PL,

  /**
  * LeaveType to store ML.
  */
  ML;

}

enum LeaveStatus {
  /**
  * LeaveStatus to store Approved.
  */
  APPROVED,

  /**
  * LeaveStatus to store Denied.
  */
  DENIED,

  /**
  * LeaveStatus to store Pending.
  */
  PENDING;

}
/**
 * LeaveDetails class to store Leave Details of employee.
 *
 * @author hexaware.
 */
 class LeaveDetails {
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
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    

    LeaveDetails lev = (LeaveDetails) obj;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String s1 = sdf.format(lev.leaveStartDate);
    String s2 = sdf.format(leaveStartDate);
    String e1 = sdf.format( lev.leaveEndDate);
    String e2 = sdf.format(leaveEndDate);
    
    String a1 = sdf.format( lev.leaveAppliedOn);
    String a2 = sdf.format(leaveAppliedOn);
    if (Objects.equals(leaveEmpId, lev.leaveEmpId)
        && Objects.equals(leaveId, lev.leaveId)
        && Objects.equals(leaveType, lev.leaveType)
        && Objects.equals(s2, s1)
        && Objects.equals(e2, e1)
        && Objects.equals(a2, a1)
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
  public String toString() {
    try {
      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      return ow.writeValueAsString(this);
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
  
}
