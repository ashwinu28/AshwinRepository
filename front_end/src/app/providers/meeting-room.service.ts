import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { reserveRoom } from '../Model/reserveRoom';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MeetingRoomService {


  public meetingRoom: reserveRoom;
  constructor(private _http:HttpClient) { }


// getRoom(roomNo): Observable<Object>{

//   console.log(roomNo);
//   return this._http.get(environment.url+'/search/roomNo/'+roomNo);



// }
getRoom(): Observable<any>{
  
  return this._http.get(environment.url+'/meeting/get');

}

getBuilding(building:any): Observable<any>{
  return this._http.get(environment.url+'/meeting/find/'+building);
}








}
