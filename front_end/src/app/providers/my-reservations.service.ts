import { Injectable } from '@angular/core';
import { reservation } from '../Model/reservation';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MyReservationsService {

  public Reservation:reservation;
  constructor(private _http:HttpClient) { }


getReservation(): Observable<any>{
  
return this._http.get(environment.url+'/reserve/search');
   

}


}
