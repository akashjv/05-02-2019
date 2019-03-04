import { Component, OnInit } from '@angular/core';
import { LeavehistoryService } from '../leavehistory.service';
import { Observable } from 'rxjs';
import { Leavehistory } from "../leavehistory";
import { Router } from '@angular/router';
@Component({
  selector: 'app-employee',
  templateUrl: './leavehistory.component.html',
  styleUrls: ['./leavehistory.component.css']
})
export class LeavehistoryComponent implements OnInit {

  leaves : Observable<Leavehistory[]>;
  empId:number;
  // empManagerId:number;

   constructor(private LeavehistoryService : LeavehistoryService,private _router:Router) {
     this.leaves = LeavehistoryService.searchLeavehistory(this.empId);
    }
    login(empId) {
      localStorage.setItem("leaveEmpId",empId);
      this._router.navigate(["/login1"]);
    }
 

  ngOnInit() {
  }

}