import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../Employee.service';
import { Employee } from "../employee";
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent implements OnInit {
  employes : Observable<Employee[]>;
  empFullName: string;
  
  constructor(private employeeService : EmployeeService,private _router:Router) {
    this.employes = employeeService.getEmployee();
    }

  ngOnInit() {
  }

}
