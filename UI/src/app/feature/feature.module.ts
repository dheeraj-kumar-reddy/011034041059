import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { StudentComponent } from './student/student.component';
import { TeachingFacultyComponent } from './teaching-faculty/teaching-faculty.component';
import { NonTeachingFacultyComponent } from './non-teaching-faculty/non-teaching-faculty.component';



@NgModule({
  declarations: [
    HomeComponent,
    LoginComponent,
    StudentComponent,
    TeachingFacultyComponent,
    NonTeachingFacultyComponent
  ],
  imports: [
    CommonModule
  ]
})
export class FeatureModule { }
