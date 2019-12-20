import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { FoodService } from '../food.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-food-item-edit',
  templateUrl: './food-item-edit.component.html',
  styleUrls: ['./food-item-edit.component.css']
})
export class FoodItemEditComponent implements OnInit {
  foodItem:any;
  category:any;
  editForm:FormGroup;
  freeDelivery:boolean;
  active:boolean;
  updatedFreeDelivery:string;
  updatedActive:string;
  itemId:any;
  id:any;
  userType:any;
  dateString:string;

  constructor(private foodService:FoodService,
                private actRouter:ActivatedRoute,
                private router:Router,
                private auth:AuthServiceService,
                private datePipe:DatePipe){

              this.editForm=new FormGroup({
                  'id': new FormControl(""),
                  'name':new FormControl(""),
                  'price':new FormControl(""),
                  'dateOfLaunch':new FormControl(""),
                  'freeDelivery':new FormControl(""),
                  'active':new FormControl(""),
                  'division':new FormGroup({
                      'category':new FormControl("")
                   }),
              });
}

  ngOnInit() {
  this.category=this.foodService.getAllCategory();
  this.actRouter.paramMap.subscribe(params=>{
  this.itemId=params.get('itemId')
  this.foodService.getMenuItem(this.itemId)
  .subscribe((response)=>{
      this.foodItem=response;
      this.dateString=this.datePipe.transform(this.foodItem.dateOfLaunch,'MM/dd/yyyy');
      if(this.foodItem.active=="Yes"){
        this.active=true;
      }
      else{
        this.active=false;
      }
      if(this.foodItem.freeDelivery=="Yes"){
        this.freeDelivery=true;
      }
      else{
        this.freeDelivery=false;
      }
      this.editForm=new FormGroup({
        'id': new FormControl(this.foodItem.id),
        'name':new FormControl(this.foodItem.name,
                                [Validators.required,Validators.minLength(2),Validators.maxLength(10)]),
        'price':new FormControl(this.foodItem.price,[Validators.required]),
        'dateOfLaunch':new FormControl(this.dateString,
                                        [Validators.required,Validators.pattern("^(1[0-2]|0[1-9])/(3[0-1]|[12][0-9]|0[1-9])/[0-9]{4}$") ]),
        'freeDelivery':new FormControl(this.freeDelivery),
        'active':new FormControl(this.active,[Validators.required]),
        'division':new FormGroup({
                  'category':new FormControl(this.foodItem.category,[Validators.required],)
                   }),
         });
  });
  });
  }

  send(editForm){
    if(editForm.freeDelivery==true){
      this.updatedFreeDelivery="Yes";
    }
    else{
      this.updatedFreeDelivery="No";
    }
    if(editForm.active==true){
      this.updatedActive="Yes";
    }
    else{
      this.updatedActive="No";
    }
    let foodItem={
        id:editForm.id,
        image: this.foodItem.image,
        name:editForm.name,
        price:editForm.price,
        active:this.updatedActive,
        freeDelivery:this.updatedFreeDelivery,
        dateOfLaunch:new Date(editForm.dateOfLaunch),
        category:editForm.division.category,
    }
    this.foodService.update(foodItem)
        .subscribe((response)=>{
            this.id=editForm.id;
            this.router.navigate(['/food-menu',this.id]);
        })
     
  }

  logout(){
    this.auth.logout();
    this.userType= this.auth.role;
  }
  
}
