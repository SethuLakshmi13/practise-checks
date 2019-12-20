import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserServiceService } from '../site/user-service.service';
import { Router } from '@angular/router';
import { AuthServiceService } from '../site/auth-service.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup;
  userName: any;
  password: any;
  signupStatus:any;
  
  constructor(private userService:UserServiceService,private authService:AuthServiceService,private router:Router) { }

  ngOnInit() {
    this.loginForm=new FormGroup({
      'userName':new FormControl(this.userName,[Validators.required]),
      'password':new FormControl(this.password,[Validators.required])
    });
  }

  send(loginForm){
    this.authService.authenticate(loginForm.value.userName,loginForm.value.password)
    .subscribe((response)=>{
      this.authService.setToken(response.token);
      this.userService.setRole(response.role);
      this.userService.setUsers(response.user);
      this.authService.login();
      this.router.navigate(['food-menu']);
     },
    (responseError)=>{
      this.signupStatus=true;
    });
  }
}
