import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BudgetType, ContractType, Currency, Vacancy } from 'src/app/models/vacancy.model';
import { VacancyService } from 'src/app/services/vacancy.service';

@Component({
  selector: 'app-add-vacancy',
  templateUrl: './add-vacancy.component.html',
  styleUrls: ['./add-vacancy.component.css']
})
export class AddVacancyComponent implements OnInit {

  vacancy: Vacancy = {
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

  budgetType = BudgetType;
  currency = Currency;
  contractType = ContractType;

  submitted = false;

  valuesBudgetType(): Array<string> {
    return Object.values(this.budgetType);
  }

  valuesCurrency(): Array<string> {
    return Object.values(this.currency);
  }

  valuesContractType(): Array<string> {
    return Object.values(this.contractType);
  }

  constructor(private router: Router, private vacancyService: VacancyService) { }

  ngOnInit(): void {
  }

  saveVacancy(): void {
    const data = {

      title: this.vacancy.title,
      budget: this.vacancy.budget,
      budgetType: this.vacancy.budgetType,
      currency: this.vacancy.currency,
      contractType: this.vacancy.contractType,
      description: this.vacancy.description,
      contact: this.vacancy.contact,
      client: this.vacancy.client,
      status: this.vacancy.status,
      skillTags: this.vacancy.skillTags
    };

    this.vacancyService.create(data).subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      });
  }

  newVacancy(): void {
    this.submitted = false;
    this.vacancy = {
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
  }

}
