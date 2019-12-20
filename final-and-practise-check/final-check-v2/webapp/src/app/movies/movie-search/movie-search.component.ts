import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-movie-search',
  templateUrl: './movie-search.component.html',
  styleUrls: ['./movie-search.component.css']
})
export class MovieSearchComponent implements OnInit {

  @Output() search:any;
  searchString:string;
  
  constructor() { 
    this.search=new EventEmitter();
   }

  ngOnInit() {
  }
  filterData(){
    this.search.emit(this.searchString);
  }

}
