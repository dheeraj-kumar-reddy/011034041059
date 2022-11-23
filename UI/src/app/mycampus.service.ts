import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class MycampusService {
url="http://localhost:8090/mycampus/adduser";
gurl="http://localhost:8090/mycampus/login";
  constructor(private http:HttpClient) { }
  saveUser(data: any){
    console.warn(data)
    return this.http.post(this.url,data);
  }
  searchUser(data: any){
    console.warn(data)
    return(this.http.post(this.gurl,data))
  }
}
