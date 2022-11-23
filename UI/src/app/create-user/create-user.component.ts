import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MycampusService } from '../mycampus.service';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css'],
 
})
export class CreateUserComponent implements OnInit {
  selectedTeam = '';
  constructor(private mycampus: MycampusService, private http: HttpClient) { }
  alert: boolean = false
  
  createUser = new FormGroup({
    name: new FormControl(''),
    password: new FormControl(''),
    emailId: new FormControl(''),
    dateOfBirth: new FormControl(''),
    gender: new FormControl(''),
    mobileNo: new FormControl('')
    
  });
  ngOnInit(): void {
  }
  saveUser() {
    this.mycampus.saveUser(this.createUser.value).subscribe((result: any) => {
      this.alert = true
      this.createUser.reset({})
      const httpOptions: { headers: any; observe: any; } = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        }),
        observe: 'response'
      };
      
      console.warn(result)
      alert("Your Username is " + result["username"] + " Save for further logins")
    })
  }

  closeAlert() {
    this.alert = false
  }
  
 
}
