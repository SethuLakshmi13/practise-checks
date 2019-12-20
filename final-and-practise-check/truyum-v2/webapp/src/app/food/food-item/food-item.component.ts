import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FoodService } from '../food.service';
import { Food } from '../food';
import { Router } from '@angular/router';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {
  
  @Input() items:any;
  @Input() status:any;
  @Input() id:any;
  @Input() userRole:any;
  @Input() cartItemId:any;
  @Input() category:any;
  @Output() addItem:any;
  @Output() edit:any;
  
  constructor( private router:Router) {
    this.addItem=new EventEmitter();
    this.edit=new EventEmitter();
  }
  ngOnInit() {}
  
  getId(id){
    if(this.userRole=="anonymous"){
      this.router.navigate(['login']);
    }else{
    this.addItem.emit(id)
    }
  }
  clickEdit(id){
      this.edit.emit(id);
  }
}
