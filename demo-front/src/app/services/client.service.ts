import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../models/client.model';

const baseUrl = 'http://localhost:8080/clients';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

    getAll(): Observable<Client[]> {
      return this.http.get<Client[]>(baseUrl);
    }

    get(id: any): Observable<Client> {
      return this.http.get(`${baseUrl}/${id}`);
    }
  
    create(data: any): Observable<any> {
      return this.http.post(`${baseUrl}`, data);
    }
  
    update(id: any, data: any): Observable<any> {
      return this.http.put(`${baseUrl}/${id}`, data);
    }
  
    delete(id: any): Observable<any> {
      return this.http.delete(`${baseUrl}/${id}`);
    }

    findByName(name: any): Observable<Client[]> {
      return this.http.get<Client[]>(`${baseUrl}?name=${name}`);
    }
}
