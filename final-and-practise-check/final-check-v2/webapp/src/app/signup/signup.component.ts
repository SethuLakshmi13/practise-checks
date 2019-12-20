import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../site/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm:FormGroup
  userName: any;
  firstName: any;
  lastName: any;
  password: any;
  confirmPassword: any;
  status:boolean;
  userExist:boolean=false;

  constructor(private userService:UserService,private router:Router) { }

  ngOnInit() {
    this.signupForm=new FormGroup({
      'userName':new FormControl(this.userName,[Validators.required]),
      'firstName':new FormControl(this.firstName,[Validators.required]),
      'lastName':new FormControl(this.lastName,[Validators.required]),
      'password':new FormControl(this.password,[Validators.required]),
      'confirmPassword':new FormControl(this.confirmPassword,[Validators.required]),
    });
  }
  send(signupForm){
    this.status=false;
    if(signupForm.value.password!=signupForm.value.confirmPassword){
      this.status=true;
    }
    else{
      this.userService.addUser(signupForm.value)
      .subscribe((response)=>{
         this.router.navigate(['login']);
      },
     (responseError)=>{
         if(responseError.error.message==="User Already Exist"){
         this.userExist=true;
         }
      });
   }
 }

}
