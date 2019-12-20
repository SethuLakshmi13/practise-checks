import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  userArray:any[];
  users:string;
  role="anonymous";

  constructor(private httpClient:HttpClient) {
    
   }
 
  addUser(user){
    return this.httpClient.post(environment.userUrl,user);
  }

  setUsers(user){
    this.users=user;
  }

  getUsers(){
    return this.users;
  }

  setRole(role){
    this.role=role;
  }
  
  getRole(){
    return this.role;
  }
    
  

}
