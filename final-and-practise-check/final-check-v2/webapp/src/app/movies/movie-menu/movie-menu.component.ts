import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/site/auth.service';
import { UserService } from 'src/app/site/user.service';

@Component({
  selector: 'app-movie-menu',
  templateUrl: './movie-menu.component.html',
  styleUrls: ['./movie-menu.component.css']
})
export class MovieMenuComponent implements OnInit {
  movieList:any;
  filteredMovieList:any;
  id:any;
  oneMovie:any;
  favoriteMovieId:number=0;
  favoriteStatus: boolean=false;
  userRole:String;
  user:any;
  anonymousAddId=0;
  
 
  constructor(private movieService:MovieService,
              private router:Router,
              private actRouter:ActivatedRoute,
              private auth:AuthService,
              private userService:UserService) { }

  ngOnInit() {
    this.favoriteStatus=false;
    this.userRole=this.getRole();
    this.user=this.userService.getUsers();
    this.movieService.getAllMovieList()
    .subscribe((response)=>{
          this.movieList=response;
          this.filteredMovieList=this.movieList;
          this.anonymousAddId=this.auth.getId();
          if(this.anonymousAddId!=0){
            this.movieService.addToFavorites(this.user,this.anonymousAddId)
            .subscribe((response)=>{
                this.favoriteMovieId=this.anonymousAddId;
                this.favoriteStatus=true;
                this.auth.setId(0);
            });
          }
          this.actRouter.paramMap
            .subscribe(params =>{
                this.id=params.get('id');
            });
    });
  }

  getRole(){
    this.userRole=this.auth.getRole();
    if(this.userRole == "anonymous"){
       this.favoriteStatus=false;
     }
    return this.userRole;
  }

  filteredData($event){
    this.filteredMovieList=this.movieService.filterData($event,this.movieList);
  }

  displayEdit($event){
    this.router.navigate(['edit-movie-list',$event]);
  }

  addNewMovie($event){
    this.user=this.userService.getUsers();
    this.movieService.addToFavorites(this.user,$event)
    .subscribe((response)=>{
          this.favoriteMovieId=$event;
          this.favoriteStatus=true;
    });
  }

}
