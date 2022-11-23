import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateUserComponent} from './create-user/create-user.component';
import { LoginUserComponent} from './login-user/login-user.component';


const routes: Routes = [
  {
    component:CreateUserComponent,
    path:"register"
  },
  {
    component:LoginUserComponent,
    path:"login"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
