import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-new-user-dialog',
  templateUrl: './new-user-dialog.component.html',
  styleUrls: ['./new-user-dialog.component.css']
})
export class NewUserDialogComponent implements OnInit {
  

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }
  register(){

    const dialogRef = this.dialog.open(NewUserDialogComponent, {
      width: '600px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  
   
  }
}
