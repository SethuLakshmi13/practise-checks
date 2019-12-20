import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../site/user.service';
import { AuthService } from '../site/auth.service';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm:FormGroup;
  userName: any;
  password: any;
  signupStatus:boolean=false;
  loginStatus:boolean=false;
  
  constructor(private userService:UserService,private auth:AuthService,private router:Router) { }

  ngOnInit() {
    this.loginForm=new FormGroup({
      'userName':new FormControl(this.userName,[Validators.required]),
      'password':new FormControl(this.password,[Validators.required])
    });
  }
 
  send(loginForm){
    this.auth.authenticate(loginForm.value.userName,loginForm.value.password)
    .subscribe((response)=>{
        this.auth.setToken(response.token);
        this.auth.setRole(response.role);
        this.userService.setUsers(response.user);
        this.auth.login();
        this.router.navigate(['movie-menu']);
     },
    (responseError)=>{
        this.signupStatus=true;
    });
  }
}
