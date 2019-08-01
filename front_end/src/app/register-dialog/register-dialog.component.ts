import { Component, OnInit } from '@angular/core';
import { MatDialog, ErrorStateMatcher, MatDialogRef } from '@angular/material';

import { FormGroup, FormControl, Validators,NgModel, FormGroupDirective, NgForm, FormBuilder, ValidatorFn } from '@angular/forms';
import { AbstractControl} from '@angular/forms';
import {MatBottomSheet, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { BottomSheetComponent } from '../bottom-sheet/bottom-sheet.component';
import { NewUserDialogComponent } from '../new-user-dialog/new-user-dialog.component';



@Component({
  selector: 'app-register-dialog',
  templateUrl: './register-dialog.component.html',
  styleUrls: ['./register-dialog.component.css']
})


export class RegisterDialogComponent implements OnInit  {

;
  constructor(public dialogRef: MatDialogRef<RegisterDialogComponent>,
    private _bottomSheet: MatBottomSheet) {}

  
  openBottomSheet(){
    this._bottomSheet.open(BottomSheetComponent);
  }

  ngOnInit(){}

  	dialog: any;

    hide =true;
 
    submitted = true;
    
   register(){

    const dialogRef = this.dialog.open(NewUserDialogComponent, {
      width: '400px',
      data: {}
    });
  
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.submitted=false;
    });
    this.dialogRef.close();
  
  }
  








}