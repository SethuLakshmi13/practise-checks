import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthServiceService } from '../site/auth-service.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  
  foodItems: any;
  filteredFoodItems: any;
  freeDelivery: any;
  active: any;
  category = [{ id: 1, name: "Main Course" }, { id: 2, name: "Starters" }, { id: 3, name: "Dessert" }];

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };

  constructor(private httpClient: HttpClient, private authenticateService: AuthServiceService) {}

  getAllFoodItems() {
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(environment.menuUrl+"/items", httpOptions)
  }

  getMenuItem(itemId) {
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(environment.menuUrl+"/"+itemId, httpOptions)
  }

  getAllCategory() {
    return this.category;
  }

  filterData($event,foodItems) {
    let filter = $event.toLocaleLowerCase();
    return  foodItems.filter(food =>
        food.name.toLocaleLowerCase().indexOf(filter) != -1);
  }
  
  getOneItem($event) {
    for (let items of this.foodItems) {
      if (items.id == $event) {
        return items;
      }
    }
  }

  update(foodItem) {
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.put(environment.menuUrl+"/items",foodItem,httpOptions)
  }

  addCartItem(user,$event){
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.post(environment.cartUrl+"/"+user +"/"+$event,{},httpOptions)
  }
  
}