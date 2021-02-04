import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Candidate } from '../models/candidate.model';
import { Vacancy } from '../models/vacancy.model';

const baseUrl = 'http://localhost:8080/candidates';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class CandidateService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Candidate[]> {
    return this.http.get<Candidate[]>(baseUrl);
  }

  get(id: any): Observable<Candidate> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: Candidate): Observable<any> {
    return this.http.post(`${baseUrl}`, { ...data, skillTags: data.skillTags?.split(', ')});
  }

  update(id: any, data: Candidate): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, { ...data, skillTags: data.skillTags?.split(', ')});
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  findBySurname(surname: any): Observable<Candidate[]> {
    return this.http.get<Candidate[]>(`${baseUrl}?surname=${surname}`);
  }

  findVacanciesByCandidateId(id: any): Observable<Vacancy[]> {
    return this.http.get<Vacancy[]>(`${baseUrl}/${id}/vacancies`);
  }

}
