import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DemoService {
  sayHello() : string{
    return "wELCOME TO ANGULAR";
  }
  topic() : string{
    return "Angular 7 service concept..";
  }

  constructor() { }
}
