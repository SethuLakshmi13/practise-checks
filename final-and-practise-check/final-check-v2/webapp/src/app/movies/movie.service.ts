import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from '../site/auth.service';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  moviesList:any;
  hasTrailer:any;
  active:any;
  filteredMovieList:any;
  
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };

  constructor(private httpClient: HttpClient, private authenticateService:AuthService) {

  }
  
  getAllMovieList() {
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(environment.movieUrl, httpOptions)
  }
 
  getGenre(){
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(environment.movieUrl+"/genre", httpOptions)
  }

  filterData($event,movieList){
    let filter=$event.toLocaleLowerCase();
    return movieList.filter(movie=>
      movie.title.toLocaleLowerCase().indexOf(filter) != -1);
  }
  
  update(movieLists) {
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.put(environment.movieUrl,movieLists,httpOptions)
  }

  getOneMovie(movieId) {
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(environment.movieUrl+"/"+movieId, httpOptions);
  }

  addToFavorites(user,$event){
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.post(environment.favoritesUrl+"/"+user+"/"+$event,{}, httpOptions);
  }
  
}
