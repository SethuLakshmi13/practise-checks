import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-edit-movie-list',
  templateUrl: './edit-movie-list.component.html',
  styleUrls: ['./edit-movie-list.component.css']
})
export class EditMovieListComponent implements OnInit {

  movieList:any;
  genre:any;
  movieId:any;
  active:boolean;
  hasTeaser:boolean;
  updatedHasTeaser:string;
  updatedActive:string;
  editForm:FormGroup;
  id:any;
  dateString: any;

  constructor(private movieService:MovieService,private actRouter:ActivatedRoute,
                  private router:Router,private datePipe:DatePipe) {

    this.editForm=new FormGroup({
      'id': new FormControl(""),
      'title':new FormControl(""),
      'boxOffice':new FormControl(""),
      'dateOfLaunch':new FormControl(""),
      'hasTeaser':new FormControl(""),
      'active':new FormControl(""),
      'division':new FormGroup({
                'genre':new FormControl("")
      }),
    });

  }

  ngOnInit() {
    this.movieService.getGenre()
    .subscribe((response)=>{
     this.genre=response;
     this.actRouter.paramMap
    .subscribe(params=>{
           this.movieId= params.get('movieId');
           this.movieService.getOneMovie(this.movieId)
           .subscribe((response)=>{
                  this.movieList=response;
                  this.dateString=this.datePipe.transform(this.movieList.dateOfLaunch,'MM/dd/yyyy');
                  if(this.movieList.active=="Yes"){
                    this.active=true;
                  }
                  else{
                    this.active=false;
                  }
                  if(this.movieList.hasTeaser=="Yes"){
                    this.hasTeaser=true;
                  }
                  else{
                    this.hasTeaser=false;
                  }
                  this.editForm=new FormGroup({
                          'id': new FormControl(this.movieList.id),
                          'title':new FormControl(this.movieList.title,
                                            [Validators.required,Validators.minLength(2),Validators.maxLength(10)]),
                          'boxOffice':new FormControl(this.movieList.boxOffice,[Validators.required],),
                          'dateOfLaunch':new FormControl(this.dateString,
                                            [Validators.required,Validators.pattern("^(1[0-2]|0[1-9])/(3[0-1]|[12][0-9]|0[1-9])/[0-9]{4}$") ],),
                          
                          'hasTeaser':new FormControl(this.hasTeaser),
                          'active':new FormControl(this.active,[Validators.required],),
                          'division':new FormGroup({
                                    'genre':new FormControl(this.movieList.genre,[Validators.required],)
                          }),
                         
                  });
            });
    });
  });
    
  }

  send(editForm){
    if(editForm.hasTeaser==true){
      this.updatedHasTeaser="Yes";
    }
    else{
      this.updatedHasTeaser="No";
    }
    if(editForm.active==true){
      this.updatedActive="Yes";
    }
    else{
      this.updatedActive="No";
    }

    let movieLists={
      id:editForm.id,
      image: this.movieList.image,
      title:editForm.title,
      boxOffice:editForm.boxOffice,
      active:this.updatedActive,
      hasTeaser:this.updatedHasTeaser,
      dateOfLaunch:new Date(editForm.dateOfLaunch),
      genre:editForm.division.genre,
      description:this.movieList.description,
      runtime:this.movieList.runtime,
      like:this.movieList.like,
      language:this.movieList.language,
      trailer:this.movieList.trailer,
      rating:this.movieList.rating
    }

  this.movieService.update(movieLists)
      .subscribe((response)=>{
              this.id=editForm.id;
              this.router.navigate(['/movie-menu',this.id]);
      });
   
  }
}

