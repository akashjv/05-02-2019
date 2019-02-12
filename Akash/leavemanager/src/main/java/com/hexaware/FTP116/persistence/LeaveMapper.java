package com.hexaware.FTP116.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.FTP116.model.LeaveDetails;
import com.hexaware.FTP116.model.LeaveStatus;
import com.hexaware.FTP116.model.LeaveType;
/**
 * Mapper class to map from result set to leave object.
 */
public class LeaveMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   *
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    /**
     * @return Leave
     */
    String s1 = rs.getString("LEA_LEAVE_TYPE");
    LeaveType l1 = LeaveType.valueOf(s1);

    String s2 = rs.getString("LEA_STATUS");
    LeaveStatus l2 = LeaveStatus.valueOf(s2);
    /**
     * @ return LeaveHistory
     */

    return new LeaveDetails(rs.getInt("EMP_ID"), rs.getInt("LEA_LEAVE_ID"), l1,
                        rs.getDate("LEA_START_DATE"), rs.getDate("LEA_END_DATE"),
                        rs.getDate("LEA_APPLIED_ON"), rs.getString("LEA_REASON"),
                        rs.getInt("LEA_NUM_OF_DAYS"), l2,
                        rs.getString("LEA_MANAGER_COMMENTS"));
  }
}
