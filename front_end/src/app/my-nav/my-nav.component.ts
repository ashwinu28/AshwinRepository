import { Component, OnInit, HostListener } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { MatDialog } from '@angular/material';
import { RegisterDialogComponent } from '../register-dialog/register-dialog.component';
import { NewUserDialogComponent } from '../new-user-dialog/new-user-dialog.component';
import { Router } from '@angular/router';
import { AuthService } from '../providers/auth.service';
import { RegisterService } from '../providers/register.service';

@Component({
  selector: 'app-my-nav',
  templateUrl: './my-nav.component.html',
  styleUrls: ['./my-nav.component.css']
})
export class MyNavComponent implements OnInit{
  

  id:String;
  isLoggedIn:any ;
  nav:any;
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );


    @HostListener('appearAgain', ['$event'])
    onAppearAgain(event: any) {    
      // Logs the id of the element 
      // where the event is originally invoked.     
      this.isLoggedIn = localStorage.getItem('isLoggedIn');
    }
    
  constructor(private router: Router,public authService: AuthService,private breakpointObserver: BreakpointObserver,public dialog: MatDialog,public registerService:RegisterService) {
    this.nav = document.getElementById('nav');
       
  }

  submitted=true;

signIn(){

  const dialogRef = this.dialog.open(RegisterDialogComponent, {
    width: '400px',
    data: {}
  });

  dialogRef.afterClosed().subscribe(result => {
    console.log('The dialog was closed');
  });
this.submitted=false;
 
}


  ngOnInit() {

    this.id = localStorage.getItem('token');
    this.isLoggedIn = localStorage.getItem('isLoggedIn');
    console.log(this.isLoggedIn);
    
    
  }
    
    logout(): void {
      
 
      this.registerService.getLogout().subscribe(data=>{
        console.log("successful");
        localStorage.clear;
      localStorage.setItem('isLoggedIn',"false");
      this.isLoggedIn = localStorage.getItem('isLoggedIn');
      this.router.navigateByUrl("/home");
      },err=>{
        console.log("Failed");
      })
      
                                                       
    }

    appear(){
    
      if(this.isLoggedIn === "true"){
        return false;
      }else{
        return true;
      }
    }

    appearAgain(){
      this.nav.addEventListener("appear",function(){
        this.isLoggedIn = localStorage.getItem('isLoggedIn');
      })
    }

    

    



}