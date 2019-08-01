import { Component, OnInit } from '@angular/core';
import { MatDialog, ErrorStateMatcher, MatDialogRef } from '@angular/material';

import { FormGroup, FormControl, Validators,NgModel, FormGroupDirective, NgForm, FormBuilder, ValidatorFn } from '@angular/forms';
import { AbstractControl} from '@angular/forms';
import {MatBottomSheet, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { BottomSheetComponent } from '../bottom-sheet/bottom-sheet.component';
import { NewUserDialogComponent } from '../new-user-dialog/new-user-dialog.component';
import { Register } from '../Model/register';
import { HttpClient } from '@angular/common/http';
import { RegisterService } from '../providers/register.service';
import { invalid } from '@angular/compiler/src/render3/view/util';
// import { RegisterService } from '../providers/register.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})


export class RegisterComponent implements OnInit  {

  RegisterList:any = [];
  register : Register = new Register();
  emailExist :string='email already exist';
  emailExistFlag :boolean = false;
 password:string;
 cpassword:string;
 flag:boolean = false;
  
  constructor(public dialogRef: MatDialogRef<RegisterComponent>,private _bottomSheet: MatBottomSheet,private_http:HttpClient,private registerservice:RegisterService) {}

  
  openBottomSheet(){
    this._bottomSheet.open(BottomSheetComponent);
  }

  ngOnInit(){}

      NameFormControl = new FormControl('', [
        Validators.required      
]);

      EmailFormControl = new FormControl('',[
      Validators.required,
      Validators.email
      

]);
      PhoneFormControl = new FormControl('', [
      Validators.required,
      Validators.pattern(/(\(?[0-9]{3}\)?-?\s?[0-9]{4}-?[0-9]{4})/)
]);


      passwordFormControl = new FormControl('', [
      Validators.required,Validators.minLength(4), Validators.maxLength(10)
]);

      confirmPasswordFormControl = new FormControl('', [
      Validators.required,Validators.minLength(4), Validators.maxLength(10)
  ]);


  LoginForm: FormGroup = new FormGroup({
    name: this.NameFormControl,
    email: this.EmailFormControl,
    phone: this.PhoneFormControl

  });
  
  dialog: any;

  

getEmailErrorMessage(){
  return this.EmailFormControl.hasError('required') ? 'you must enter an email':
  this.EmailFormControl.hasError('pattern') ? 'Not a valid Email' : '';
}
getRequiredErrorMessage(field) {
  return this.LoginForm.get(field).hasError('required') ? 'Cannot leave this field blank' : '';
}

getPhoneErrorMessage() {
    return this.PhoneFormControl.hasError('required') ? 'You must enter a value' :
      this.PhoneFormControl.hasError('pattern') ? 'Format must be (xxx) xxxx-xxxx' : '';
  }

  hide =true;
  
validate(event){
let target = event.target;
let value = target.value;
this.password = value;

  
}

validatePassword(event){
  let target = event.target;
  let value = target.value;
  this.cpassword = value;


  if(this.cpassword != this.password){
    this.flag = true;
  }else{
    this.flag = false;
  }
  
    
  }


  validEmail(e){
  let email = e.target.value;
  this.registerservice.getRegister(email).subscribe(data =>{
    console.log(data);
    if(data){
      this.emailExistFlag = true;
      this.EmailFormControl.setErrors({'incorrect': true})
    }
  });
 }
  
  

  onSubmit(e) {
   

    e.preventDefault();
   let error = (this.NameFormControl.hasError('required') || this.EmailFormControl.hasError('email') || this.passwordFormControl.hasError('required')|| this.PhoneFormControl.hasError('pattern') || this.passwordFormControl.hasError('required') || this.confirmPasswordFormControl.hasError('required') || this.flag );

  this.register.name=e.target.name.value;
  this.register.email=e.target.email.value;
  this.register.phoneNo=e.target.phoneNo.value;
  this.register.password=e.target.password.value;
  

  if(!error){
  console.log(this.register);

     
      this.registerservice.createRegister(this.register)
      .subscribe(data => this.dialogRef.close()
      , error => console.log(error));
      
  }
 


}
submitted=true;



}