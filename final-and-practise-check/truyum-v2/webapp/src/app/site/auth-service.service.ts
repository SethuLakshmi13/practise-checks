import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserServiceService } from './user-service.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  role="anonymous";
  loginStatus=false;
  private authenticationApiUrl=environment.authenticateUrl;
  private token:string;

  constructor(private httpClient:HttpClient,private userService:UserServiceService) { }
  
  authenticate(user:string,password:string):Observable<any>{
    let credentials=btoa(user+':'+password);
    let headers=new HttpHeaders();
    headers=headers.set('Authorization','Basic '+credentials);
    return this.httpClient.get(this.authenticationApiUrl,{headers});
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
    this.userService.setRole("anonymous");
    this.setToken(null);
  }
  
}
