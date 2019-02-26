import { Component, OnInit } from '@angular/core';
import { UserService } from '../User.service';
import { Observable } from 'rxjs';
import { User } from "../user";
import { Router } from '@angular/router'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
 users : Observable<User[]>
 name:string;
//  show(name){
//   this.name=name;
// }
  constructor(private userService : UserService,private _router:Router) {
    this.users = userService.getUser();
   }
   login(name) {
     localStorage.setItem("name",name);
     this._router.navigate(["/login"]);
   }

  ngOnInit() {
  }

}
