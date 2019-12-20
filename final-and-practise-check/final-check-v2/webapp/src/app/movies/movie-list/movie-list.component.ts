import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { AuthService } from 'src/app/site/auth.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {
  @Input() list:any;
  @Input() id:any;
  @Input() favoriteMovieId:any;
  @Input() userRole:any;
  @Input() favoriteStatus: any;
  @Output() edit:any;
  @Output() addMovie:any
 
  constructor(private router:Router,private auth:AuthService) { 
    this.edit=new EventEmitter();
    this.addMovie=new EventEmitter();
  }

  ngOnInit() {}

  clickEdit(id){
    this.edit.emit(id);
  }

  getId(id){
    if(this.userRole=="anonymous"){
      this.auth.setId(id);
      this.router.navigate(['login']);
    }else{
      this.addMovie.emit(id)
    }
   }

}
