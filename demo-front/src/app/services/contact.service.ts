import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Contact } from '../models/contact.model';
import { Observable } from 'rxjs';
import { Client } from '../models/client.model';

const baseUrl = 'http://localhost:8080/contacts';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Contact[]> {
    return this.http.get<Contact[]>(baseUrl);
  }

  get(id: any): Observable<Contact> {
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

  findByClientName(clientName: any): Observable<Contact[]> {
    return this.http.get<Contact[]>(`${baseUrl}?clientName=${clientName}`);
  }

  getClientByContactId(id: any): Observable<Client> {
    return this.http.get(`${baseUrl}/${id}/client`);
  }

}
