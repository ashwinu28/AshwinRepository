import { Component, OnInit, Input, OnChanges, SimpleChanges, SimpleChange, HostListener } from '@angular/core';
import { SchedulerEvent } from '@progress/kendo-angular-scheduler';
import { ReservationService } from '../providers/reservation.service';
import { reservation } from '../Model/reservation';
import { Calendar } from '../Model/calendar';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements  OnInit {
 
  @Input() towers:any;
  @Input() dateOut:any;

  name:string;
  date:string;
  
 


  reservation : reservation = new reservation();
  selectedDate:Date;
  events:SchedulerEvent[];
  currentDate: Date;


  @HostListener('getReservation', ['$event'])
  onGetReservation(event: any) {   
    
    let year = event.detail.date.getFullYear();
    let month = event.detail.date.getUTCMonth()+1;
    let day = event.detail.date.getDate();

    event.detail.date=year+"-"+month+"-"+day;
    console.log(event.detail.date);
    console.log(event.detail.tower);

    
    this.selectedDate = new Date(event.detail.date);
    
    this.ReservationService.createReservation(event.detail.tower,event.detail.date).subscribe((data:any) =>{
     
      
      data.forEach(element => {
        let startDateToPush = event.detail.date+"T"+element.startTime;
        let endDateToPush = event.detail.date+"T"+element.endTime;

      
        //let startDate = new Date(2019,7,19,8,0,0);
        // let time1 = element.startTime.charAt(0);
        // let time2 = element.startTime.charAt(0);

        // let eTime1 = element.startTime.charAt(0);
        // let eTime2 = element.startTime.charAt(1);
        // let startDate = null;
        // let endDate = null;
        // if(time1 === 0){
        //   startDate = new Date(year,month,day,time2,0,0);
        // }else{
        //   let startTime = ""+time1+time2+"";
        //   let x = parseInt(startTime);
        //   startDate = new Date(year,month-1,day,x,0,0);
        // }

        // if(eTime1 === 0){

        // }
        let startTime = parseInt(""+element.startTime.charAt(0)+element.startTime.charAt(1)+"");
        let endTime = parseInt(""+element.endTime.charAt(0)+element.endTime.charAt(1)+"");
      
        //console.log(startDate);
        
       ;
        let startDate = new Date(year,month-1,day,startTime,0,0);
        let endDate = new Date(year,month-1,day,endTime,0,0);

        let  currentDate = new Date(event.detail.date);
        this.displayDate=currentDate;
        this.selectedDate = this.displayDate;
        
       
        // console.log(startDate);
        

        this.baseData.push({"Title":element.meetingRoom.roomNo,"Start":startDate,"End": endDate});
        
      
      });

      this.sampleData = this.baseData.map(dataItem => (
        <SchedulerEvent> {
             start: this.parseAdjust(dataItem.Start),
             end: this.parseAdjust(dataItem.End),
             title: dataItem.Title,
       
        }
    ));

       
       this.events = this.sampleData;
       
       console.log(this.displayDate);
      console.log(this.events);
     
     

    });
     
  


  }






  constructor(private ReservationService:ReservationService){}

  ngOnInit() {
    this.selectedDate= this.displayDate;
    this.events = this.sampleData;

  } 
  // ngOnChanges(changes: SimpleChanges): void {
  //   const dateOut: SimpleChange = changes.dateOut;
    
  
  //   let date1:Date = new Date();

  //   date1 = dateOut.currentValue;

  //   let year = date1.getFullYear();
  //   let month = date1.getUTCMonth()+1;
  //   let day = date1.getDate();

 

  //   let date:string = year+"-"+month+"-"+day;
  //   console.log(date);
    
  //   const towers: SimpleChange = changes.towers;
  //    console.log(towers.currentValue);
  //    let name:string = towers.currentValue;

  //    if(name != undefined || name != null || name != ""){
  //      this.name = name;
  //    }

  //    if(date != undefined || date != null){
  //      this.date = date;
  //    }

  //    if(this.name != undefined && this.name != null && this.name != "" && this.date != undefined && this.date != null ){
     
  //   }
     

  // }


  baseData: any[] = [ 
//     {
        
       
//         "Title": "Room 1C:Jeudi Du Partage",
//         "Start": "2019-06-24T08:00:00.000",
//         "End": "2019-06-24T09:00:00.000",
      
//     },
//     {
     
//       "Title": " Room 1A :Du Partage",
//       "Start": "2019-06-24T08:00:00.000",
//       "End": "2019-06-24T09:00:00.000",
      
//   },
//   {
   
//     "Title": " Room 1A :Du Partage",
//     "Start": "2019-06-24T11:00:00.000",
//     "End": "2019-06-24T12:00:00.000",
    
// }
];



 
 parseAdjust = (eventDate: string): Date => {
    const date = new Date(eventDate);
 
    return date;
};

//  randomInt = (min, max): number => {
//     return Math.floor(Math.random() * (max - min + 1)) + min;
// }

  displayDate = null;

  sampleData = this.baseData.map(dataItem => (
    <SchedulerEvent> {
         id: dataItem.TaskID,
         start: this.parseAdjust(dataItem.Start),
         towers:this.parseAdjust(dataItem.towers),
         startTimezone: dataItem.startTimezone,
         end: this.parseAdjust(dataItem.End),
         endTimezone: dataItem.endTimezone,
         title: dataItem.Title,
   
        //isAllDay: dataItem.IsAllDay,
         // description: dataItem.Description,
        // recurrenceRule: dataItem.RecurrenceRule,
        // recurrenceId: dataItem.RecurrenceID,
        // recurrenceException: dataItem.RecurrenceException,

        // roomId: dataItem.RoomID,
        // ownerID: dataItem.OwnerID
    }
));

  sampleDataWithResources = this.baseData.map(dataItem => (
    <SchedulerEvent> {
        id: dataItem.TaskID,
        start: this.parseAdjust(dataItem.Start),
        towers:this.parseAdjust(dataItem.towers),
        startTimezone: dataItem.startTimezone,
        end: this.parseAdjust(dataItem.End),
        endTimezone: dataItem.endTimezone,
        isAllDay: dataItem.IsAllDay,
        title: dataItem.Title,
        description: dataItem.Description,
        recurrenceRule: dataItem.RecurrenceRule,
        recurrenceId: dataItem.RecurrenceID,
        recurrenceException: dataItem.RecurrenceException,
        // roomId: this.randomInt(1, 2),
        // attendees: [this.randomInt(1, 3)]
    }
));

sampleDataWithCustomSchema = this.baseData.map(dataItem => (
    
  {
        ...dataItem,
        Start: this.parseAdjust(dataItem.Start),
        End: this.parseAdjust(dataItem.End),
     
    }
));












}
