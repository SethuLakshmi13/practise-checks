import { Component, OnInit } from '@angular/core';
import { AuthService } from '../site/auth.service';
import { UserService } from '../site/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  userRole:string;
  user:string;

  constructor( private auth:AuthService,private userService:UserService,
                    private router:Router) { 

  }

  ngOnInit() {
    this.user=this.getUsers();
  }

  getRole(){
    this.userRole=this.auth.getRole();
    return this.userRole;
  }

  getUsers(){
    this.user=this.userService.getUsers();
    return this.user;
  }

  logout(){
    this.auth.logout();
    this.auth.setId(0);
    this.router.navigate([""]);
  }

}
