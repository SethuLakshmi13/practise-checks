import { Injectable } from '@angular/core';
import { UserService } from './site/user.service';
import { AuthService } from './site/auth.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
 
//   userArray:any;
//   loginStatus:boolean=false;

//   constructor(private userService:UserService,private auth:AuthService) { }
  
//   validate(loginForm){
//     if(loginForm.value.user=="admin" && loginForm.value.password =="admin"){
//       this.auth.login(loginForm.value.user);
//       this.loginStatus=true;
//     }else{
//      this.userArray=this.userService.getUser();
//       for(let users of this.userArray){
//         if(loginForm.value.user==users.name &&loginForm.value.password==users.password){
//           this.auth.login(loginForm.value.user);
//           this.loginStatus=true;
//         }
//       }
//     }
//     return this.loginStatus;
//   }
// }
}


