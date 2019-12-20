import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  role="anonymous";
  loginStatus=false;
  token:string;
  id=0;

  constructor(private httpClient:HttpClient) { }

  authenticate(user:string,password:string):Observable<any>{
    let credentials=btoa(user+':'+password);
    let headers=new HttpHeaders();
    headers=headers.set('Authorization','Basic '+credentials);
    return this.httpClient.get(environment.authenticateUrl,{headers});
  }

  setId(id){
    this.id=id;
  }

  getId(){
    return this.id;
  }

  setRole(role){
      this.role=role;
  }
  
  getRole(){
      return this.role;
  }
  
  public setToken(token:string){
      this.token=token;
  }

  public getToken(){
      return this.token;
  }

  login(){
      this.loginStatus=true;
  }
 
  logout(){
     this.loginStatus=false;
     this.setRole("anonymous");
     this.setToken(null);
  }
   
}
