import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import { Router } from '@angular/router';
import { Leavehistory } from '../leavehistory';
import { NgForm } from '@angular/forms';
import { LeavehistoryService } from '../leavehistory.service';
@Component({
  selector: 'app-applyleave',
  templateUrl: './applyleave.component.html',
  styleUrls: ['./applyleave.component.css']
})
export class ApplyleaveComponent implements OnInit {


  constructor(public applyLeaveService:LeavehistoryService, public router : Router) {
    this.empId=parseInt(localStorage.getItem("empId"));
    alert("Employ ID " +this.empId);
   }
  model=new Leavehistory();
  message:string;
  msg:String;
  empId : number;
  isValidFormSubmitted = false;
  calculateDays() {
    let date1: string=this.model.leaveStartDate.toString();
    let date2: string=this.model.leaveEndDate.toString();
    let diffInMs: number = Date.parse(date2) - Date.parse(date1);
    let diffInHours: number = diffInMs / 1000 / 60 / 60/24;
    this.model.leaveNumOfDays=diffInHours + 1;
    
   // alert(diffInHours);
    //console.log(diffInHours);

    //alert("Event Fired");
}

applyLeave(form: NgForm)
{
    this.isValidFormSubmitted=false;
    if(form.invalid){
   //     alert("Invalid");
     return; 
  }  
    console.log ('end date component' + this.model.leaveEndDate);
    this.applyLeaveService.applyLeave(this.empId,this.model).subscribe(
        success => {
            this.msg=success;
        },
        err => { 
            this.msg=err;
            console.log(err);
        }
    )
    this.isValidFormSubmitted = true;
    setTimeout(() => {
      this.router.navigate(['/Dashboard'])
    }
    , 10000);
}

  ngOnInit() {
  }

}
