import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit ,  Inject} from '@angular/core';
import {FormGroup,FormControl} from '@angular/forms';
import { MycampusService } from '../mycampus.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  constructor(private mycampus:MycampusService,private http:HttpClient) { }
  alert:boolean=false
  loginUser=new FormGroup({
    username:new FormControl(''),
    password:new FormControl('')
    
  });
  ngOnInit(): void {
  }
  searchUser(){
    this.mycampus.searchUser(this.loginUser.value).subscribe((result: any)=>{
      const httpOptions: { headers: any; observe: any; } = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json'
        }),
        observe: 'response'
      };
      
      var valid=(result)
      if(valid["status"]==0 && valid["role"]==1){
        alert("Welcome Student")
      }
      else{
        alert("Invalid entry")
      }
      })
  }
}
