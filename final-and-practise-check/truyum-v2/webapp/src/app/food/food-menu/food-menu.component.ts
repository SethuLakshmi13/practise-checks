import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserServiceService } from 'src/app/site/user-service.service';


@Component({
  selector: 'app-food-menu',
  templateUrl: './food-menu.component.html',
  styleUrls: ['./food-menu.component.css']
})
export class FoodMenuComponent implements OnInit {
  foodItems:any;
  customerItems:any;
  oneItem:any;
  searchString:string="";
  filteredFoodItems:any;
  category:any;
  status:any;
  id:any;
  addStatus:any;
  cartItemId:number=0;
  userRole:string;
  user:string;
 
  constructor(private foodService:FoodService, 
               private router:Router, 
               private actRouter:ActivatedRoute, 
               private userService:UserServiceService) { }

  ngOnInit() {
    this.userRole=this.getRole();
    this.foodService.getAllFoodItems()
    .subscribe((response)=>{
        this.foodItems=response;
        this.filteredFoodItems=this.foodItems;
        this.actRouter.paramMap.subscribe(params =>{
        this.id=params.get('id');
        this.status="Editted Item Added Successfully";
        });
    });
  }

  getRole(){
    this.userRole=this.userService.getRole();
    if(this.userRole=="anonymous"){
       this.cartItemId=0;
    }
     return this.userRole;
  }

  filterData($event){
    this.filteredFoodItems=this.foodService.filterData($event,this.foodItems);
  }
  
  addCartItem($event){
    this.user=this.userService.getUsers();
    this.foodService.addCartItem(this.user,$event)
      .subscribe((response)=>{
          this.cartItemId=$event;
      });
  }

  displayEdit($event){
    this.router.navigate(['item-edit',$event]);
  }
}
