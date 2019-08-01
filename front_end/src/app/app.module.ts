import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MyNavComponent } from './my-nav/my-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatDialog,MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule, MatCardModule, MatTabsModule, MatFormFieldModule, MatOption, MatOptionModule, MatInput, MatInputModule, MatSelect, MatSelectModule, MatDialogModule, MatDatepickerModule, MatNativeDateModule, MatStepperModule, MatBottomSheetModule, MatCheckbox } from '@angular/material';
import { HomeComponent } from './home/home.component';
import { ReserveSpaceComponent } from './reserve-space/reserve-space.component';
import { MyreservationsComponent } from './myreservations/myreservations.component';
import { ContactusComponent } from './contactus/contactus.component';
import { LoginComponent } from './login/login.component';
import { DialogComponent } from './dialog/dialog.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterDialogComponent } from './register-dialog/register-dialog.component';
import { NewUserDialogComponent } from './new-user-dialog/new-user-dialog.component';
import { BottomSheetComponent } from './bottom-sheet/bottom-sheet.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './providers/login.service';
import { AuthGuard } from './auth.guard';
import { Routes } from '@angular/router';
import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import { SchedulerModule } from '@progress/kendo-angular-scheduler';
import { CalendarComponent } from './calendar/calendar.component';
import {MatTableModule} from '@angular/material/table';

	

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'reserve-space', component: MyNavComponent, canActivate: [AuthGuard] }
];



@NgModule({
  declarations: [
    AppComponent,
    MyNavComponent,
    HomeComponent,
    ReserveSpaceComponent,
    MyreservationsComponent,
    ContactusComponent,
    LoginComponent,
    DialogComponent,
    RegisterDialogComponent,
    NewUserDialogComponent,
    BottomSheetComponent,
    RegisterComponent,
    CalendarComponent
    
    
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatTabsModule,
    MatFormFieldModule,
    MatInputModule,
    MatOptionModule,
    MatSelectModule,
    FormsModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatStepperModule,
    ReactiveFormsModule,
    MatBottomSheetModule,
   HttpClientModule,
   NgxMaterialTimepickerModule,
   SchedulerModule,
   MatTableModule
 
  ],


  providers: [LoginService,AuthGuard],
  bootstrap: [AppComponent],
  entryComponents:[RegisterDialogComponent,BottomSheetComponent]
})
export class AppModule { 
 

}
