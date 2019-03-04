import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../Employee.service';
import { Employee } from "../employee";
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { LeavehistoryService } from '../leavehistory.service';
import { Leavehistory } from "../leavehistory";

@Component({
  selector: 'app-approve-deny',
  templateUrl: './approve-deny.component.html',
  styleUrls: ['./approve-deny.component.css']
})
export class ApproveDenyComponent implements OnInit {
  employ : Observable<Employee>;
  leave : Observable<Leavehistory[]>;
  empId:number;
  leaveEmpId:number;
  leaveStatus:string;
  obj = new Leavehistory();
  leaveId:number;
  msg:string;
  empManagerId:number;


  constructor(private employeeService : EmployeeService,private _router :Router,private LeavehistoryService : LeavehistoryService) {
    this.empId=parseInt(localStorage.getItem("empId"));
    this.leaveId=parseInt(localStorage.getItem("leaveId"));
    this.leaveEmpId=parseInt(localStorage.getItem("lempId"));
    alert(this.leaveEmpId);


    this.employ = employeeService.searchEmployee(this.leaveEmpId);
    this.leave = LeavehistoryService.getLeaveDetail(this.leaveId);
    //this.employ=employeeService.searchApproveDeny(this.leaveEmpId);
   }
   Approve() {
     this.obj.leaveId=this.leaveId;
     this.leaveStatus="YES";
     this.LeavehistoryService.approveDeny(this.empId,this.leaveStatus,this.obj).subscribe(
       dd=>{
         this.msg=dd;
       },
       errorMsg => {
         this.msg=errorMsg;
         console.log(errorMsg);
       }
     )
   }
   Deny() {
    this.obj.leaveId=this.leaveId;
    this.leaveStatus="NO";
    this.LeavehistoryService.approveDeny(this.empId,this.leaveStatus,this.obj).subscribe(
      dd=>{
        this.msg=dd;
      },
      errorMsg => {
        this.msg=errorMsg;
        console.log(errorMsg);
      }
    )
  }
  cancel() {
    this._router.navigate(["/dashboard"]);
  }

  ngOnInit() {
  }

}
