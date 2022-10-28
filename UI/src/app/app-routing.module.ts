import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./feature/home/home.component";
import {LoginComponent} from "./feature/login/login.component";
import {NonTeachingFacultyComponent} from "./feature/non-teaching-faculty/non-teaching-faculty.component";
import {TeachingFacultyComponent} from "./feature/teaching-faculty/teaching-faculty.component";
import {StudentComponent} from "./feature/student/student.component";

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
