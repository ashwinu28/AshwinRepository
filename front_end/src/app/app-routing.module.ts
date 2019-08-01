import { NgModule } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MyreservationsComponent } from './myreservations/myreservations.component';
import { ReserveSpaceComponent } from './reserve-space/reserve-space.component';
import { ContactusComponent } from './contactus/contactus.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [

  {path: 'home' , component: HomeComponent},
  {path: 'myreservations' , component: MyreservationsComponent},
  {path: 'reserve-space' , component:ReserveSpaceComponent},
  {path: 'contactus' , component:ContactusComponent},
  {path: 'login' , component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
