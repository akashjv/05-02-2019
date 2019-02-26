import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LeavehistoryService } from '../leavehistory.service';
import { Leavehistory } from "../leavehistory";
import { Router } from '@angular/router';
@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  leave : Observable<Leavehistory[]>;
  leaveEmpId : number;

  constructor(private leavehistoryService : LeavehistoryService,private _router:Router) { 
    this.leaveEmpId = parseInt(localStorage.getItem("empId"));
    this.leave = leavehistoryService.searchLeavehistory(this.leaveEmpId);
  }
  apply() {
    this._router.navigate(["/applyLeave"]);
  }

  ngOnInit() {
  }

}
