import { Injectable } from '@angular/core';
import { reservation } from '../Model/reservation';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {



  public Reservation:reservation;
  constructor(private _http:HttpClient) { }



createReservation(name,date): Observable<Object>{
  console.log(reservation);
  let url = environment.url+'/reserve/reservation/'+name+"/"+date;
  console.log(url)
  return this._http.get(url);
}

getUnavailableRoom(buildingName,startTime,endTime,date): Observable<object>{

  let url  = environment.url+'/reserve/select/'+buildingName+"/"+startTime+"/"+endTime+"/"+date;
  return this._http.get(url);
}


createBooking(reservation):Observable<object>{

  return this._http.post(environment.url+'/reserve/add',reservation);
}



}
