package com.hexaware.FTP116.util;

import java.text.ParseException;
import java.util.Scanner;

import com.hexaware.FTP116.model.Employee;
import com.hexaware.FTP116.model.LeaveDetails;
import com.hexaware.FTP116.model.LeaveType;



/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. leave History");
    System.out.println("5. leave Pending");
    System.out.println("6. Approve Deny");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        leaveHistory();
        break;
      case 5:
        leavePending();
        break;
      case 6:
        appDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding.
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2 or 3");
    }
    mainMenu();
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(employee.getEmpId() + " " + employee.getEmpFullName() + " "
          + employee.getEmpMobileNo() + " " + employee.getEmpDateOfJoining() + " "
          + employee.getEmpDepartment() + " " + employee.getEmpLeaveBalance() + " "
          + employee.getEmpManagerId());
    }
  }
  private void leavePending() {
    System.out.println("Enter the employee (Manager) ID:");
    int empId = option.nextInt();
    LeaveDetails[] leaveHistory = LeaveDetails.listPending(empId);
    for (LeaveDetails e : leaveHistory) {
      System.out.println(e);
    }
  }
  private void leaveHistory() {
    System.out.println("Enter the Employee Id: ");
    int empId = option.nextInt();
    LeaveDetails[] leaveHistory = LeaveDetails.listAll(empId);
    for (LeaveDetails e : leaveHistory) {
      System.out.println(e);
    }
  }
  private void appDeny() {
    System.out.println("Enter Leave Id: ");
    int leaveId = option.nextInt();
    System.out.println("Enter Manager Id: ");
    int empManagerId = option.nextInt();
    System.out.println("Approved (YES/NO) ");
    String leaveStatus = option.next();
    System.out.println("Manager comments");
    String leaveMgrComments = option.next();
    String res = LeaveDetails.approveDeny(leaveId, empManagerId, leaveStatus, leaveMgrComments);
    System.out.println(res);
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + " ");
    }
  }
  private void applyLeave() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Employee Id: ");
    int empId = sc.nextInt();
    System.out.println("Enter the StartDate :(yyyy-MM-dd");
    String leaStartDate = sc.next();
    System.out.println("Enter the EndDate :(yyyy-MM-dd");
    String leaEndDate = sc.next();
    System.out.println("Enter number of LeaveDays");
    int leaNumOfDays = sc.nextInt();
    System.out.println("Enter LeaveType");
    String leaLeaveType = sc.next();
    LeaveType lt = LeaveType.valueOf(leaLeaveType);
    System.out.println("Enter Leave Reason ");
    String leaReason = sc.next();
    String res = "";
    try {
      res = LeaveDetails.applyLeave(leaStartDate, leaEndDate, leaNumOfDays, leaReason, empId, lt);
    } catch (ParseException e) {
      System.out.println("please enter proper date");
    }
    System.out.println(res);
  }
  /**
   * The main entry point.
   * @param ar the list of arguments.
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
