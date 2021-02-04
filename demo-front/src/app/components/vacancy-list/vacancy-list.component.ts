import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vacancy } from 'src/app/models/vacancy.model';
import { VacancyService } from 'src/app/services/vacancy.service';

@Component({
  selector: 'app-vacancy-list',
  templateUrl: './vacancy-list.component.html',
  styleUrls: ['./vacancy-list.component.css']
})
export class VacancyListComponent implements OnInit {

  vacancies?: Vacancy[];
  currentVacancy?: Vacancy;
  currentIndex = -1;
  clientName = '';

  constructor(private router: Router, private vacancyService: VacancyService) { }

  ngOnInit(): void {
    this.retrieveVacancies();
  }
  
  retrieveVacancies(): void {
    this.vacancyService.getAll().subscribe(
      data => {
        this.vacancies = data;
        console.log(data)
      },
      error => {
        console.log(error);
      })
  }

  refreshList(): void {
    this.retrieveVacancies();
    this.currentVacancy = undefined;
    this.currentIndex = -1;
  }

  setActiveVacancy(vacancy: Vacancy, index: number): void {
    this.currentVacancy = vacancy;
    this.currentIndex = index;
  }

  searchName(): void {
    this.vacancyService.findByClientName(this.clientName).subscribe(
      data => {
        this.vacancies = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });

  }

}
