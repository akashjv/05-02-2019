import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from "../employee";
import { EmployeeService } from "../employee.Service";
// import { Router } from '@angular/router';


@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {
  employ : Observable<Employee>;
  empId:number;
  empManagerId:number;
 //  show(name){
 //   this.name=name;
 // }
   constructor(private employeeService : EmployeeService) {
     this.empId = parseInt(localStorage.getItem("empManagerId"));
     this.employ = employeeService.searchEmployee(this.empId);
   }
  ngOnInit() {
  }

}