import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../Employee.service';
import { Observable } from 'rxjs';
import { Employee } from "../employee";
import { Router } from '@angular/router';
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employes : Observable<Employee[]>;
  empId:number;
  empManagerId:number;

   constructor(private employeeService : EmployeeService,private _router:Router) {
     this.employes = employeeService.getEmployee();
    }
    login(empId,empManagerId) {
      localStorage.setItem("empId",empId);
      localStorage.setItem("empManagerId",empManagerId);
      this._router.navigate(["/login"]);
    }

  ngOnInit() {
  }

}
