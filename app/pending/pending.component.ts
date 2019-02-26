import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LeavehistoryService } from '../leavehistory.service';
import { Leavehistory } from "../leavehistory";
import { EmployeeService } from '../Employee.service';
import { Employee } from "../employee";
import { Router } from "@angular/router";

@Component({
  selector: 'app-pending',
  templateUrl: './pending.component.html',
  styleUrls: ['./pending.component.css']
})
export class PendingComponent implements OnInit {

  leavees : Observable<Leavehistory[]>;

  employes : Observable<Employee[]>;
  empId : number;
  showButton : boolean;

  constructor(private leavehistoryService : LeavehistoryService,private employeeService : EmployeeService,private _router :Router) { 
    this.empId = parseInt(localStorage.getItem("empId"));
    this.showButton=false;
    this.leavees = leavehistoryService.searchLeavepending(this.empId);
    this.employes = employeeService.getEmployee();
  }
setClickRow(leaveId,empId){ 
  alert(leaveId);
  alert("Pending " +empId);
  localStorage.setItem("leaveId",leaveId);
  localStorage.setItem("lempId",empId);
  this.showButton=true;

}

approveDeny() {

  this._router.navigate(["/approveDeny"]);
}
  ngOnInit() {
  }

}
