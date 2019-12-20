import { Component, OnInit } from '@angular/core';
import { FavoriteService } from '../favorite.service';
import { UserService } from 'src/app/site/user.service';
import { AuthService } from 'src/app/site/auth.service';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {
  favoriteList:any;
  noOfFavorites:any;
  removeStatus:boolean=false;
  favoritesEmptyStatus:boolean;
  user:string;
  anonymousAddId=0;

  constructor(private favoriteService:FavoriteService,private userService:UserService,
                  private auth:AuthService) { 
                  
  }

  ngOnInit() {
    this.user=this.userService.getUsers();
    this.anonymousAddId=this.auth.getId();
    if(this.anonymousAddId!=0){
        this.getAllFavorites()
      }
    this.favoriteService.getAllFavorites(this.user)
    .subscribe((response)=>{
          if(response==null){
          this.favoritesEmptyStatus=true;
          }else{
            this.favoriteList=response["movieList"];
            this.noOfFavorites=response["noOfFavorites"];
          }
     },
    (responseError)=>{
          if(responseError.error.message==="Favorites is Empty"){
          this.favoritesEmptyStatus=true;
          } 
    });
  }

  getAllFavorites(){
    this.favoriteService.getAllFavorites(this.user)
    .subscribe((response)=>{
            if(response==null){
                this.favoritesEmptyStatus=true;
            }else{
                this.favoriteList=response["movieList"];
                this.noOfFavorites=response["noOfFavorites"];
            }
    },
    (responseError)=>{
            if(responseError.error.message==="Favorites is Empty"){
                this.favoritesEmptyStatus=true;
            }
    });
  }

  removeFavorite(id){
    this.user=this.userService.getUsers();
    this.favoriteService.removeFavorite(this.user,id)
    .subscribe((response)=>{
          this.removeStatus=true;
          this.favoriteService.getAllFavorites(this.user)
              .subscribe((response)=>{
                      this.favoriteList=response["movieList"];
                      this.noOfFavorites=response["noOfFavorites"];
               },
              (responseError)=>{
                      if(responseError.error.message==="Favorites is Empty"){
                      this.favoritesEmptyStatus=true;
                      }
              });
    });
  }

}
