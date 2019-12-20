import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CartService } from '../cart.service';
import { Cart } from '../cart';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { UserServiceService } from 'src/app/site/user-service.service';
import { isFormattedError } from '@angular/compiler';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  
  cartItems:any;
  total:number=0;
  removeStatus:boolean=false;
  cartEmptyStatus:boolean=false;
  user:string;

  constructor(private cartService:CartService,private userService:UserServiceService) {}

  ngOnInit() {
    this.cartService.getAllCartItem(this.userService.getUsers())
    
    .subscribe((response)=>{
         if(response==null){
            this.cartEmptyStatus=true;
         }else{
           this.cartItems=response["menuItemList"];
           this.total=response["total"];
        }
    },
    (responseError)=>{
        if(responseError.error.message==="Cart is Empty"){
            this.cartEmptyStatus=true;
        }
    });
  }

  getId(id){
    this.user=this.userService.getUsers();
    this.cartService.removeCartItem(id,this.user)
    
    .subscribe((response)=>{
      this.removeStatus=true;
      this.cartService.getAllCartItem(this.userService.getUsers())
        
      .subscribe((response)=>{
            this.cartItems=response["menuItemList"];
            this.total=response["total"];
        },
      (responseError)=>{
            if(responseError.error.message==="Cart is Empty"){
                this.cartEmptyStatus=true;
             }
        });

    });
  }
 
}



