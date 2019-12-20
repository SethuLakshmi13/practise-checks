import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AuthService } from '../site/auth.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FavoriteService {

  favoriteList:any;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',

    })
  };
  
  constructor(private httpClient:HttpClient,private authService:AuthService) { 
  }

  getAllFavorites(user){
    let token = 'Bearer ' + this.authService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(environment.favoritesUrl+"/"+user,httpOptions)
  }

  removeFavorite(user,id){
    let token = 'Bearer ' + this.authService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.delete(environment.favoritesUrl+"/"+user+"/"+id,httpOptions)
    
  }
}
