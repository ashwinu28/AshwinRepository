import { Injectable } from '@angular/core';
import { Login } from '../Model/login';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Register } from '../Model/register';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  public login: Login;

  public register: Register;
  constructor(private _http:HttpClient) {
    this.login = new Login();
   }



  getRegister(email:any): Observable<Object>{
    console.log(email)
    return this._http.get(environment.url+'/register/search/'+email);
  }

  getRegisterObject(email:any){
    console.log(email)
    return this._http.get(environment.url+'/register/register/'+email).pipe(map((data:any)=>{
      if(data!=null || data !=undefined){
        this.login.email = data.email;
        this.login.password = data.password;
      }
      
    }));
  }
  
  getPassword(password:any): Observable<Object>{
    console.log(password);
   
    return this._http.get(environment.url+'/register/search/'+password);
  }




}






