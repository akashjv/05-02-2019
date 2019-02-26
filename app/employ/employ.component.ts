import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { EmployeeService } from '../Employee.service';
import { Employee } from "../employee";

@Component({
  selector: 'app-employ',
  templateUrl: './employ.component.html',
  styleUrls: ['./employ.component.css']
})
export class EmployComponent implements OnInit {
  employ : Observable<Employee>;
  empId : number;

  constructor(private employeeService : EmployeeService) { 
    this.empId = parseInt(localStorage.getItem("empId"));
    this.employ = employeeService.searchEmployee(this.empId);
  }

  ngOnInit() {
  }

}
