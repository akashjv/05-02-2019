import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Leavehistory } from "./leavehistory";
import 'rxjs/add/operator/map';


@Injectable({
  providedIn: 'root'
})
export class LeavehistoryService {

  constructor( private http : Http ) {
  }
  searchLeavehistory(empId:number): Observable<Leavehistory[]> {
    return this.http.get
    ("http://localhost:8080/FTP116/api/leavedetails/leavehistory/"+empId)
    .map((res: Response) => res.json());
  }
  searchLeavepending(empId:number): Observable<Leavehistory[]> {
    return this.http.get
    ("http://localhost:8080/FTP116/api/leavedetails/leavepending/"+empId)
    .map((res: Response) => res.json());
  }
  approveDeny(empManagerId:number,leaveStatus:string,leavedetails:Leavehistory): Observable<string> {
    return this.http.post
    ("http://localhost:8080/FTP116/api/leavedetails/approvedeny/"+empManagerId+"/"+leaveStatus,leavedetails)
    .map((res: Response) => res.text());
  }  
  getLeaveDetail(empId:number): Observable<Leavehistory[]> {
    return this.http.get
    ("http://localhost:8080/FTP116/api/leavedetails/"+empId)
    .map((res: Response) => res.json());
  }
  applyLeave(empId:number,leavedetails:Leavehistory): Observable<string> {
    return this.http.post
    ("http://localhost:8080/FTP116/api/leavedetails/applyleave/"+empId,leavedetails)
    .map((res: Response) => res.text());
  }  
}
