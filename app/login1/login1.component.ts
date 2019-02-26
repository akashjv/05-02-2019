import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login1',
  templateUrl: './login1.component.html',
  styleUrls: ['./login1.component.css']
})
export class Login1Component implements OnInit {
  username:string;
  password:string;
  constructor(private _router : Router) {
    this.username = localStorage.getItem("leaveEmpId");
   }
   login(){
     this._router.navigate(["/dashboard"])
    //  if(this.username == localStorage.getItem("leaveEmpId") && this.password == "fantu") 
    //   {
    //     alert ("hahaha");
    //   } else {
    //     alert("incorrect password");
    //   }
    // }
   }

   ngOnInit() {
   }

}