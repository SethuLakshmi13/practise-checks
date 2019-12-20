import { BrowserModule,} from '@angular/platform-browser';
import { NgModule,} from '@angular/core';
import { HttpClientModule,} from '@angular/common/http';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations'


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieMenuComponent } from './movies/movie-menu/movie-menu.component';
import { MovieListComponent } from './movies/movie-list/movie-list.component';
import { EditMovieListComponent } from './movies/edit-movie-list/edit-movie-list.component';
import { MovieSearchComponent } from './movies/movie-search/movie-search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FavoriteComponent } from './favorites/favorite/favorite.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HeaderComponent } from './header/header.component';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    MovieMenuComponent,
    MovieListComponent,
    EditMovieListComponent,
    MovieSearchComponent,
    FavoriteComponent,
    LoginComponent,
    SignupComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    DatePipe,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
