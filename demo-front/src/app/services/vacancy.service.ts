import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vacancy } from '../models/vacancy.model';
import { Candidate } from '../models/candidate.model';

const baseUrl = 'http://localhost:8080/vacancies';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class VacancyService {

  constructor(private http: HttpClient) { }

    getAll(): Observable<Vacancy[]> {
      return this.http.get<Vacancy[]>(baseUrl);
    }

    get(id: any): Observable<Vacancy> {
      return this.http.get(`${baseUrl}/${id}`);
    }
  
    create(data: Vacancy): Observable<any> {
      return this.http.post(`${baseUrl}`, { ...data, skillTags: data.skillTags?.split(', ')});
    }
  
    update(id: any, data: any): Observable<any> {
      return this.http.put(`${baseUrl}/${id}`, data);
    }
  
    delete(id: any): Observable<any> {
      return this.http.delete(`${baseUrl}/${id}`);
    }

    findByClientName(clientName: any): Observable<Vacancy[]> {
      return this.http.get<Vacancy[]>(`${baseUrl}?clientName=${clientName}`);
    }

    getCandidatesByVacancyId(id: any): Observable<Candidate[]> {
      return this.http.get<Candidate[]>(`${baseUrl}/${id}/candidates`);
    }

}
