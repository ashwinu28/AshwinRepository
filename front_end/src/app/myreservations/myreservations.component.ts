
  import { Component, OnInit } from '@angular/core';
import { MyReservationsService } from '../providers/my-reservations.service';
import { BottomSheetComponent } from '../bottom-sheet/bottom-sheet.component';


@Component({
  selector: 'app-myreservations',
  templateUrl: './myreservations.component.html',
  styleUrls: ['./myreservations.component.css']
})
export class MyreservationsComponent implements OnInit {
  displayedColumns: string[] = ['date', 'startTime', 'endTime','tower','roomNo','event_name','event_type','info','register_email'];
  dataSource :any;
  _bottomSheet: any;



  constructor(public myReservationService:MyReservationsService) {}
  ngOnInit(): void {
    

this.myReservationService.getReservation().subscribe(data => {
  console.log(data)
  this.dataSource=data
}
, error => console.log(error));

  }

}
