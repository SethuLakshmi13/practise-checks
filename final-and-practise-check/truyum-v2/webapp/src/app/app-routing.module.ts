import { NgModule } from '@angular/core';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
import { CartComponent } from './shopping/cart/cart.component';
import { FoodMenuComponent } from './food/food-menu/food-menu.component';
import { FoodItemEditComponent } from './food/food-item-edit/food-item-edit.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AuthGuard } from './site/auth.guard';


const routes: Routes = [
  {path:'',component:FoodMenuComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'food-menu/:id',component:FoodMenuComponent,canActivate:[AuthGuard]},
  {path:'food-menu',component:FoodMenuComponent,canActivate:[AuthGuard]},
  {path:'cart/:addStatus',component:CartComponent,canActivate:[AuthGuard]},
  {path:'cart',component:CartComponent,canActivate:[AuthGuard]},
  {path:'item-edit/:itemId',component:FoodItemEditComponent,canActivate:[AuthGuard]},
  {path:'item-edit',component:FoodItemEditComponent,canActivate:[AuthGuard]}
                         ];
const routerOptions:ExtraOptions={
  useHash: false,
  anchorScrolling :'enabled',
  onSameUrlNavigation:'reload'
  
};

@NgModule({
  imports: [RouterModule.forRoot(routes,routerOptions)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
