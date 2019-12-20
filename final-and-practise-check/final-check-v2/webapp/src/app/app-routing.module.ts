import { NgModule } from '@angular/core';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
import { EditMovieListComponent } from './movies/edit-movie-list/edit-movie-list.component';
import { MovieMenuComponent } from './movies/movie-menu/movie-menu.component';
import { FavoriteComponent } from './favorites/favorite/favorite.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './site/auth.guard';

const routes: Routes = [
                        {path:'',component:MovieMenuComponent},
                        {path:'signup',component:SignupComponent},
                        {path:'login',component:LoginComponent},
                        {path:'movie-menu/:id',component:MovieMenuComponent,canActivate:[AuthGuard]},
                        {path:'movie-menu',component:MovieMenuComponent,canActivate:[AuthGuard]},
                        {path:'edit-movie-list/:movieId',component:EditMovieListComponent,canActivate:[AuthGuard]},
                        {path:'edit-movie-list',component:EditMovieListComponent,canActivate:[AuthGuard]},
                        {path:'favorite',component:FavoriteComponent,canActivate:[AuthGuard]},];
                
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
