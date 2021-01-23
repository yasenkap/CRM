import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class RestapiService {

  constructor(private http:HttpClient) { }

  public login(userName:string, password: string){
    let headers = new HttpHeaders({Authorization: 'Basic' + btoa(userName+":"+password)})
    this.http.get("http://localhost:8080/", {headers, responseType: 'text' as 'json'});
  }
}
