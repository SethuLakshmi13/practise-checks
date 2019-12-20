import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AuthServiceService } from '../site/auth-service.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems:any;
  total:number=0;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',

    })
  };

  constructor(private httpClient:HttpClient,private authenticateService:AuthServiceService) { }
  
  getAllCartItem(user){
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(environment.cartUrl+"/"+user,httpOptions)
  }

  removeCartItem(id,user){
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.delete(environment.cartUrl+"/"+user +"/"+id,httpOptions)
  }
}
