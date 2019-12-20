import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../site/auth-service.service';
import { UserServiceService } from '../site/user-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userType:any;
  user:string;
  
  constructor(private auth:AuthServiceService,private userService:UserServiceService,
                private router:Router) { }
  
  ngOnInit() {
  }

  getRole(){
    this.userType=this.userService.getRole();
    return this.userType;
  }

  getUsers(){
    this.user=this.userService.getUsers();
    return this.user;
  }

  logout(){
    this.auth.logout();
    this.router.navigate([""]);
  }
}
