import { BrowserModule } from '@angular/platform-browser';
import { RouterModule,Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { EmployeeComponent } from './employee/employee.component';
import { Login1Component } from './login1/login1.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EmployComponent } from './employ/employ.component';
import { ManagerComponent } from './manager/manager.component';
import { LeavehistoryComponent } from './leavehistory/leavehistory.component';
import { HistoryComponent } from './history/history.component';
import { PendingComponent } from './pending/pending.component';
import { ApproveDenyComponent } from './approve-deny/approve-deny.component';
import { DropdownComponent } from './dropdown/dropdown.component';
import { ApplyleaveComponent } from './applyleave/applyleave.component';
const data:Routes = [
  {path:'',component:EmployeeComponent},
  {path:'login',component:LoginComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'approveDeny',component :ApproveDenyComponent},
  {path:'applyLeave',component :ApplyleaveComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent,
    UserComponent,
    LoginComponent,
    EmployeeComponent,
    Login1Component,
    DashboardComponent,
    EmployComponent,
    ManagerComponent,
    LeavehistoryComponent,
    HistoryComponent,
    PendingComponent,
    ApproveDenyComponent,
    DropdownComponent,
    ApplyleaveComponent
  ],
  imports: [
    BrowserModule,HttpModule,
    FormsModule,
    RouterModule.forRoot(data)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
