import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FoodItemComponent } from './food/food-item/food-item.component';
import { FoodMenuComponent } from './food/food-menu/food-menu.component';
import { FoodSearchComponent } from './food/food-search/food-search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CartComponent } from './shopping/cart/cart.component';
import { FoodItemEditComponent } from './food/food-item-edit/food-item-edit.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    FoodItemComponent,
    FoodMenuComponent,
    FoodSearchComponent,
    CartComponent,
    FoodItemEditComponent,
    SignupComponent,
    LoginComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    DatePipe,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
