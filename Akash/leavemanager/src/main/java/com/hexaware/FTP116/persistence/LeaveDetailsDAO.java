package com.hexaware.FTP116.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;

import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;

import com.hexaware.FTP116.model.LeaveDetails;
import com.hexaware.FTP116.model.LeaveStatus;
import com.hexaware.FTP116.model.LeaveType;


/**
 * The DAO class for leaveDetailsDao.
 */
public interface LeaveDetailsDAO  {
    /**
     * return all the details of all the LeaveDetails.
     * @param empId the id of the employee.
     * @return the employee object.
     */
  @SqlQuery("SELECT * FROM LEAVEDETAILS WHERE EMP_ID = :empId")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> leaveHistory(@Bind("empId") int empId);
  /**
   * return all the details of the selected LeaveDetails.
   * @param leaveId the id of the LeaveId.
   * @return the employee object.
   */
  @SqlQuery("SELECT * FROM LEAVEDETAILS WHERE LEA_LEAVE_ID = :leaveId")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> listById(@Bind("leaveId") int leaveId);

  /**
   * return all the details of the selected LeaveDetails.
   * @param leaveId the id of the LeaveId.
   * @return the employee object.
   */
  @SqlQuery("SELECT * FROM LEAVEDETAILS WHERE LEA_LEAVE_ID = :leaveId")
  @Mapper(LeaveMapper.class)
  LeaveDetails listById1(@Bind("leaveId") int leaveId);
  /**
   * return count for already applied leave history.
   * @param empId the id of employee.
   * @param leaStartdate is the start date.
   * @param leaEnddate is the end date.
   * @return total records.
   */
  @SqlQuery ("SELECT COUNT(*) FROM LEAVEDETAILS WHERE EMP_ID = :empId "
      +
      "         AND LEA_STATUS = 'PENDING' AND "
      +
      "         (LEA_START_DATE <= :leaStartdate AND LEA_END_DATE >= :leaStartdate) OR "
      +
      "         (LEA_START_DATE <= :leaEnddate AND LEA_END_DATE >= :leaEnddate)")
  int count(@Bind("empId") int empId,
                  @Bind("leaStartdate") String leaStartdate,
                  @Bind("leaEnddate") String leaEnddate);

 /**
   * insert all the details of the employee.
   * @param leaStartdate the start date of the leave.
   * @param leaEnddate the end date of the leave.
   * @param leanumofdays the number of days.
   * @param leaappliedon the applied date of the leave.
   * @param leaReason the reason for leave.
   * @param empId the employee id.
   * @param leastatus the status of leave.
   * @param lealeavetype the type of leave.
   */
  @SqlUpdate("insert into LEAVEDETAILS "
             +
             "             (LEA_START_DATE, "
             +
             "              LEA_END_DATE, "
             +
             "              LEA_NUM_OF_DAYS, "
             +
             "              LEA_APPLIED_ON, "
             +
             "              LEA_REASON, "
             +
             "              EMP_ID, "
             +
             "              LEA_STATUS, "
             +
             "              LEA_LEAVE_TYPE) "
             +
             "values       ( "
             +
             "              :leaStartdate, "
             +
             "              :leaEnddate, "
             +
             "              :leanumofdays, "
             +
             "              :leaappliedon, "
             +
             "              :leaReason, "
             +
             "              :empId, "
             +
             "              :leastatus, "
             +
             "              :lealeavetype)")
  void insert(@Bind("leaStartdate") String leaStartdate,
              @Bind("leaEnddate") String leaEnddate,
              @Bind("leanumofdays") int leanumofdays,
              @Bind("leaappliedon") String leaappliedon,
              @Bind("leaReason") String leaReason,
              @Bind("empId") int empId,
              @Bind("leastatus") LeaveStatus leastatus,
              @Bind("lealeavetype") LeaveType lealeavetype);

  /**
   * return all the details of the selected employee.
   *@param empId the id of the manager.
   *@return the Pending leaves of the manager.
   */
  @SqlQuery("SELECT * FROM LEAVEDETAILS WHERE EMP_ID IN "
        +
        " (SELECT E2.EMP_ID FROM EMPLOYEDETAILS E1 INNER JOIN EMPLOYEDETAILS E2 "
        +
        " ON E1.EMP_ID=E2.EMP_MGR_ID "
        +
        " WHERE E1.EMP_ID= :empId) "
        +
        " AND LEA_STATUS= 'PENDING' "
        )
      @Mapper(LeaveMapper.class)
    List<LeaveDetails> pending(@Bind("empId") int empId);
    /**
     * update approveDeny Status.
     * @param leaveStatus leaveStatus final value.
     * @param mgrComments the manager response.
     * @param leaveId leave Id of approve/Deny.
     */
  @SqlUpdate("UPDATE LEAVEDETAILS SET LEA_STATUS = :leaveStatus, "
             +
             "LEA_MANAGER_COMMENTS = :mgrComments WHERE LEA_LEAVE_ID = :leaveId")
             void approveOrDeny(@Bind("leaveId") int leaveId,
                              @Bind("leaveStatus") String leaveStatus,
                              @Bind("mgrComments") String mgrComments
                              );

  /**
   * close with no args is used to close the connection.
   */
  void close();

}

