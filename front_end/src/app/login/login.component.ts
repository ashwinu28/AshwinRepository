import { Component, OnInit } from '@angular/core';
import { MatDialog, ErrorStateMatcher, MatDialogRef } from '@angular/material';

import { FormGroup, FormControl, Validators,NgModel, FormGroupDirective, NgForm, FormBuilder, ValidatorFn } from '@angular/forms';
import { AbstractControl} from '@angular/forms';
import {MatBottomSheet, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { BottomSheetComponent } from '../bottom-sheet/bottom-sheet.component';
import { NewUserDialogComponent } from '../new-user-dialog/new-user-dialog.component';
import { Login } from '../Model/login';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../providers/login.service';
import { AuthService } from '../providers/auth.service';
import { Router } from '@angular/router';
import { Register } from '../Model/register';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit  {

  LoginList: any = [];  
  login: Login = new Login();

RegisterList: any =[];
register : Register = new Register();

emailExistFlag : boolean = false;

 
  password:String;
  returnUrl:String;
  message:String = "invalid email or password";

//  password:string = null;
 cpassword:string = null;
 flag:boolean = false;
  constructor(public dialogRef: MatDialogRef<LoginComponent>,private router: Router,private _bottomSheet: MatBottomSheet,private _http:HttpClient,private loginservice:LoginService, public authService: AuthService) {
    this.login = this.loginservice.login;
  }

  
  openBottomSheet(){
    this._bottomSheet.open(BottomSheetComponent);
  }

  ngOnInit(){
this.returnUrl='/reserve-space';
this.authService.logout();
  }


  EmailFormControl = new FormControl('',[
    Validators.required,
    Validators.email
    
]);
      passwordFormControl = new FormControl('', [
      Validators.required,
      Validators.minLength(8), 
      Validators.maxLength(25)
]);



  LoginForm: FormGroup = new FormGroup({
   
    email: this.EmailFormControl,
   password:this.passwordFormControl
   

  });
  
  dialog: any;

  getRequiredErrorMessage(field) {
  return this.LoginForm.get(field).hasError('required') ? 'Cannot leave this field blank' : '';
}

hide =true;
  
   

validate(event){
let target = event.target;
let value = target.value;
this.password = value;

  
}


  onSubmit(e){
   let email = e.target.email.value;
   let password = e.target.loginPass.value;
   console.log(email);
   console.log(password);
  

   this.loginservice.getRegisterObject(email).subscribe((data)=>{
     
     if(this.login.email === email){

      if(this.login.password === password){
        localStorage.setItem('isLoggedIn', "true");
        let elem = document.getElementById('nav');
       

    let event = new Event("appearAgain");
    elem.dispatchEvent(event);
        

        this.router.navigateByUrl("/reserve-space");
        this.dialogRef.close();
      }
      else{
        this.passwordFormControl.setErrors({'incorrect': true});
      }

     }else{
      this.EmailFormControl.setErrors({'incorrect': true})
     }
    
    
   })
      
 
 
      //     console.log("Login successful");
  //     //this.authService.authLogin(this.model);
  //     localStorage.setItem('isLoggedIn', "true");
  //     localStorage.setItem('token', this.f.email.value);
  //     this.router.navigate([this.returnUrl]);
  //   }
  //   else{
  //     this.message = "Please check your email and password";
  //   }
     
  //   let error = (this.EmailFormControl.hasError('required') || this.EmailFormControl.hasError('email') || this.passwordFormControl.hasError('required'));
    
  //   this.login.email=e.target.email.value;
  //  this.login.password=e.target.loginPass.value;
   
      
    }
     

     validEmail(e){
      let email = e.target.value;
      this.loginservice.getRegister(email).subscribe(data =>{
        console.log(data);
        if(!data){
          this.emailExistFlag = true;
          this.EmailFormControl.setErrors({'incorrect': true})
        }
      });
     }

     


  // onSubmit(e) {
  //   e.preventDefault();
  // console.log(e.target.email.value);
  // console.log(e.target.loginPass.value);
  // }


}