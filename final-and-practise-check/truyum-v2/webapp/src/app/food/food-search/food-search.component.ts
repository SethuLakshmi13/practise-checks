import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { EmitterVisitorContext } from '@angular/compiler';

@Component({
  selector: 'app-food-search',
  templateUrl: './food-search.component.html',
  styleUrls: ['./food-search.component.css']
})
export class FoodSearchComponent implements OnInit {
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
