import { Component, OnInit, Input, Output, EventEmitter, HostListener } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Tower } from '../interface';
import { building } from '../Model/building';
import { BuildingService } from '../providers/building.service';
import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import { SchedulerEvent } from '@progress/kendo-angular-scheduler';
import { MeetingRoomService } from '../providers/meeting-room.service';
import { reserveRoom } from '../Model/reserveRoom';
import { ReservationService } from '../providers/reservation.service';
import { MatStepper } from '@angular/material/stepper';
import { reservation } from '../Model/reservation';
import { StepperSelectionEvent } from '@angular/cdk/stepper';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reserve-space',
  templateUrl: './reserve-space.component.html',
  styleUrls: ['./reserve-space.component.css']
})

export class ReserveSpaceComponent implements OnInit {
  @Output() valueChange = new EventEmitter<String>();
  towerSelect:any;
  dateSelect:any;
  towerSelect1:any;

  // startSelect:Date;
  // endSelect:Date;
reservation:reservation= new reservation();
unavailableRoomslist:reserveRoom[]=[];
 MeetingRoomList:reserveRoom[]=[];
buildingList:building[]=[];
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  myForm:FormGroup;
  firstCtrlDate:FormControl;
  firstCtrlStart:FormControl;
  firstCtrlEnd:FormControl;
  firstCtrlTower:FormControl;
  secondCtrlRoom:FormControl;
  thirdCtrlName:FormControl;
  thirdCtrlType:FormControl;
  thirdCtrlWifi:FormControl;
  thirdCtrlClient:FormControl;
  thirdCtrlInfo:FormControl;
  thirdCtrlPublic:FormControl;


  constructor(private _formBuilder: FormBuilder,private buildingService:BuildingService,private MeetingRoomService:MeetingRoomService,private reservationService:ReservationService,
    private router:Router) { }
  
//today's date
todaydate:Date = new Date();



  ngOnInit() {
   
    
     this.validators();
    this.getTower();

  }
 
validators(){
 this.firstFormGroup = this._formBuilder.group({
      firstCtrlDate :this._formBuilder.control('date', Validators.required),
      firstCtrlStart: ['', Validators.required],
     
      firstCtrlEnd: ['', Validators.required],
      firstCtrlTower: this._formBuilder.control('tower', Validators.required),
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrlRoom:this._formBuilder.control('room', Validators.required),
    });

    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrlName:['', Validators.required],
     
      thirdCtrlType: ['', Validators.required],
     
      thirdCtrlWifi: ['', Validators.required],
     
      thirdCtrlClient: ['', Validators.required],
     
      thirdCtrlInfo: ['', Validators.required],
     
      thirdCtrlPublic: ['', Validators.required],
      
     
    });
}
  stepChanged(event: StepperSelectionEvent) {
    if (event.previouslySelectedIndex > event.selectedIndex) {
     event.previouslySelectedStep.interacted = false;
    }
  }
  goBack(stepper: MatStepper){
      stepper.previous();
  }
  
  goForward(stepper: MatStepper){
      stepper.next();
  }
//   ReservationForm : FormGroup = new FormGroup({
// date:this.firstFormGroup,
// start:this.firstFormGroup,

//   });

private getTower(){
  this.buildingService.getBuildingName().subscribe(data => {
   
    
data.forEach(element => {
  let tower:building = new building();
  
  tower.name = element.name;
 this.buildingList.push(tower);
});
 
  
  })
}

 getRooms(building){
  this.MeetingRoomService.getBuilding(building).subscribe(data => {
   
  this.MeetingRoomList = [];
 data.forEach(element => {
   let room: reserveRoom = new reserveRoom();
   
   room.roomNo = element.roomNo;
   room.flag=false;
  this.MeetingRoomList.push(room);
 });
  console.log("meetingRooms",this.MeetingRoomList) ;
   
   })
 }



 private  parseTimeIntoNumber(time:string): number{
  return parseInt(time);
 }

 private parseDate(date:Date) : string{
  
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
}


compareTwoTime(startTime:string, endTime:string){
  let am:string = "am";
  let pm:string = "pm";

  let startTimeInt = parseInt(startTime);
  let endTimeInt = parseInt(endTime);

  if(startTime.indexOf(pm) != -1){
    startTimeInt += 12;
  }

  if(endTime.indexOf(pm) != -1){
    endTimeInt += 12;
  }

  if(startTimeInt===endTimeInt || endTimeInt < startTimeInt){
    this.firstFormGroup.controls['firstCtrlEnd'].setErrors({'invalid': true});
  }


}


 
 
  

captureDate(stepper:MatStepper){

 let date=this.firstFormGroup.controls['firstCtrlDate'].value;
 console.log(this.firstFormGroup.controls['firstCtrlStart'].value);

//  if(date === undefined || date === null || date ==='date' || date ===''){
  if (date && date != 'date'){
    
   this.firstFormGroup.controls['firstCtrlDate'].setErrors({'incorrect': false});
}else{
  this.firstFormGroup.controls['firstCtrlDate'].setErrors({'incorrect': true});
 
}
this.dateSelect = date;


 let start = this.firstFormGroup.controls['firstCtrlStart'].value;

 if(start){
  this.firstFormGroup.controls['firstCtrlStart'].setErrors({'incorrect': false});
 }else{
  this.firstFormGroup.controls['firstCtrlStart'].setErrors({'incorrect': true});
 }

let finish = this.firstFormGroup.controls['firstCtrlEnd'].value;
if(finish){
 this.firstFormGroup.controls['firstCtrlEnd'].setErrors({'incorrect': false});
}else{
  this.firstFormGroup.controls['firstCtrlEnd'].setErrors({'incorrect': true});
}



 let tower =this.firstFormGroup.controls['firstCtrlTower'].value;
 if(tower && tower != 'tower'){
  this.firstFormGroup.controls['firstCtrlStart'].setErrors({'incorrect': false});
 }else{
 this.firstFormGroup.controls['firstCtrlTower'].setErrors({'incorrect': true});
}
 this.towerSelect = tower;



//  this.secondFormGroup.controls['secondCtrlRoom'].setErrors({'incorrect': true});




 
 let kendo = document.getElementById("kendo");
 let data = {"tower":tower,"date":date};
 let event = new CustomEvent("getReservation", {"detail":data});
 
 
    kendo.dispatchEvent(event);

    console.log("start",start);
    console.log("finish",finish);
    console.log("date",date);
    console.log("tower",tower);

  console.log("parseStartTime",this.parseTimeIntoNumber(start));
  console.log("parseEndTime",this.parseTimeIntoNumber(finish));
console.log("dateToString",this.parseDate(date));


let reserveDate = this.parseDate(date);
let reserveStart = this.parseTimeIntoNumber(start);
let reserveFinish = this.parseTimeIntoNumber(finish);

this.getRooms(tower);

this.reservationService.getUnavailableRoom(tower,reserveStart,reserveFinish,reserveDate).subscribe((data:any) =>{
  
data.forEach(element => {
  
 let room : reserveRoom = new reserveRoom();

 room.roomNo = element.meetingRoom.roomNo;
 room.flag=true;


 this.MeetingRoomList.forEach(roomInList => {
  
   if(roomInList.roomNo === room.roomNo){
     let index:number = this.MeetingRoomList.indexOf(roomInList);
     this.MeetingRoomList.splice(index,1);
     this.MeetingRoomList.push(room);
   }
 });
 

});

 });

this.compareTwoTime(start,finish);

if(this.firstFormGroup.controls['firstCtrlStart'].hasError('incorrect') || this.firstFormGroup.controls['firstCtrlDate'].hasError('incorrect') || this.firstFormGroup.controls['firstCtrlEnd'].hasError('incorrect') || this.firstFormGroup.controls['firstCtrlTower'].hasError('incorrect') || this.firstFormGroup.controls['firstCtrlEnd'].hasError('invalid')){

}else{
  stepper.linear = false;
  stepper.next();
  stepper.linear = true;
}

}

captureDate2(stepper: MatStepper){
  console.log(stepper);
  if(this.secondFormGroup.controls['secondCtrlRoom'].value != null){
    stepper.linear = false;
    stepper.next();
    stepper.linear = true;
    
  }
  else{
    stepper.next();
  stepper.linear = true;
  }
}

validate(event){
  let target = event.target;
  let value = target.value;
 
  
    
  }







onSubmit(e) {
  e.preventDefault();








  let signInBtn = document.getElementById('signIn');
   this.reservation.date=this.firstFormGroup.controls['firstCtrlDate'].value;;

let startHour = this.selectStartTime(this.firstFormGroup.controls['firstCtrlStart'].value);
let endHour = this.selectEndTime(this.firstFormGroup.controls['firstCtrlEnd'].value);

let startTime = this.buildDateFromTime(this.reservation.date,startHour);
let endTime = this.buildDateFromTime(this.reservation.date,endHour);
   

this.selectEndTime(this.firstFormGroup.controls['firstCtrlEnd'].value);
this.selectEndTime(this.firstFormGroup.controls['firstCtrlStart'].value);
this.reservation.startTime = startTime;

   this.reservation.endTime = endTime;

  this.reservation.meetingRoom=this.secondFormGroup.controls['secondCtrlRoom'].value;
  this.reservation.event_name=this.thirdFormGroup.controls['thirdCtrlName'].value;
  this.reservation.event_type=this.thirdFormGroup.controls['thirdCtrlType'].value;
  this.reservation.info=this.thirdFormGroup.controls['thirdCtrlInfo'].value;

  let isLoggedIn:string = localStorage.getItem('isLoggedIn');
  console.log(isLoggedIn);

  if(isLoggedIn === 'false'){
    let event:Event = new Event('click');
    signInBtn.dispatchEvent(event);
  }else{
    this.reservationService.createBooking(this.reservation)
    .subscribe(data =>{

      console.log(data)

    //do routing
    this.router.navigateByUrl("/myreservations");
    } 

    , error => console.log(error));
  console.log(e.target);
  }



  
}


private buildDateFromTime(date:Date, hour:number):Date{
  let dateToReturned: Date = new Date();
  dateToReturned.setFullYear(date.getFullYear());
  dateToReturned.setMonth(date.getMonth());
  dateToReturned.setDate(date.getDate());

  dateToReturned.setHours(hour);
  dateToReturned.setMinutes(0);
  dateToReturned.setSeconds(0);
  dateToReturned.setMilliseconds(0);
  return dateToReturned;

}

private selectEndTime(endTime:string): number{
  

  let pm:string = "pm";

  let hour = parseInt(endTime);

  if(endTime.indexOf(pm) != -1){
    hour += 12;
  }

  let min = parseInt(endTime.substring(3));

  if(min > 0){
    hour +=1;
  }

  return hour;


  }

  private selectStartTime(startTime:string): number{
  
   
    let pm:string = "pm";
  
    let hour = parseInt(startTime);
  
    if(startTime.indexOf(pm) != -1){
      hour += 12;
    }

    return hour;
  
  
    }


}




