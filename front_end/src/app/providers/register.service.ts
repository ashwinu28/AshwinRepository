import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Register } from '../Model/register';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {


  public register: Register;
  constructor(private _http:HttpClient,) { }



createRegister(register): Observable<Object>{
  
  console.log(register);
  return this._http.post(environment.url+'/register/add',register);
}


getRegister(email:any): Observable<Object>{
  console.log(email)
  return this._http.get(environment.url+'/register/search/'+email)
}

// isEmailRegisterd(email: string) {
//   var headers = new Headers();
//   headers.append('Content-Type', 'application/json');
//   return this._http.post('http://localhost:8080/api/v1/register/get', JSON.stringify({ email: email }), { headers: headers })
//       .map((response: Response) => response.json())
//       .catch(this.handleError);
// }

// private handleError(error: any) {
//   console.log(error);
//   return Observable.throw(error.json());
//   ;
// }


getLogout(){
  return this._http.get(environment.url+'/register/logout');
}

}
