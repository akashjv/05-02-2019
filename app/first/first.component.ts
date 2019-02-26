import { Component, OnInit } from '@angular/core';
import { DemoService } from '../demo.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {
  msg1 : string;
  msg2 : string;

  constructor (private _serv :DemoService ) {
    this.msg1 = this._serv.sayHello();
    this.msg2 = this._serv.topic();
  }

  ngOnInit() {
  }

}
