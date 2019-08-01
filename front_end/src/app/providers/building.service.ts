import { Injectable } from '@angular/core';
import { building } from '../Model/building';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BuildingService {




  constructor(private _http:HttpClient) { 

  }



getBuildingName(): Observable<any>{
  
  return this._http.get(environment.url+'/building/get');

}











}
