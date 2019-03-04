import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username:string;
  password:string;
  constructor(private _router : Router) {
    this.username = localStorage.getItem("empId");
   }
   login(){
     this._router.navigate(["/dashboard"])
  //    if(this.username == localStorage.getItem("empFullName") && this.password == "fantu") 
  //     {
  //       // alert ("hahaha");
  //     } else {
  //       alert("incorrect password");
  //     }
    }

   ngOnInit() {
   }

}
