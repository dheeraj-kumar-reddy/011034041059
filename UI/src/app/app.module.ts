import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HomeComponent} from "./feature/home/home.component";
import {LoginComponent} from "./feature/login/login.component";
import {NonTeachingFacultyComponent} from "./feature/non-teaching-faculty/non-teaching-faculty.component";
import {TeachingFacultyComponent} from "./feature/teaching-faculty/teaching-faculty.component";
import {StudentComponent} from "./feature/student/student.component";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NonTeachingFacultyComponent,
    TeachingFacultyComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
