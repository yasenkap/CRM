import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Vacancy } from 'src/app/models/vacancy.model';
import { VacancyService } from 'src/app/services/vacancy.service';

@Component({
  selector: 'app-vacancy-details',
  templateUrl: './vacancy-details.component.html',
  styleUrls: ['./vacancy-details.component.css']
})
export class VacancyDetailsComponent implements OnInit {

  currentVacancy: Vacancy = {
    title: '',
    budget: '',
    budgetType: undefined,
    currency: undefined,
    contractType: undefined,
    description: '',
    contact: undefined,
    client: undefined,
    status: undefined,
    skillTags: ''
  };

  message = '';

  constructor(
    private vacancyService: VacancyService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getVacancy(this.route.snapshot.params.id);
  }

  getVacancy(id: string): void {
    this.vacancyService.get(id)
      .subscribe(
        data => {
          this.currentVacancy = data;
          console.log(data)
          console.log(this.currentVacancy.skillTags);
        },
        error => {
          console.log(error);
        });
  }

  updateVacancy(): void {

    this.vacancyService.update(this.currentVacancy.id, this.currentVacancy)
      .subscribe(response => {
        console.log('after update: ', this.currentVacancy.skillTags);
        console.log(response);
        this.message = response.message;
        this.router.navigate(['/vacancies']);
      },
        error => {
          console.log(error);
        });
  }

  deleteVacancy(): void {
    this.vacancyService.delete(this.currentVacancy.id)
      .subscribe(response => {
        console.log(response);
        this.router.navigate(['/vacancies']);
      },
        error => {
          console.log(error);

        });
  }
}
