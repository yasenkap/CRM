import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/models/client.model';
import { BudgetType, ContractType, Currency, Vacancy } from 'src/app/models/vacancy.model';
import { ClientService } from 'src/app/services/client.service';
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

  clients: Client[];

  selectedName: string;

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

  constructor(private router: Router, private vacancyService: VacancyService, private clientService: ClientService) { 
    this.clients = [];
    this.selectedName = '';
  }

  ngOnInit(): void {
    this.retrieveClients();
  }

  retrieveClients(): void {
    this.clientService.getAll().subscribe(
      data => {
        this.clients = data;
        console.log(data)
      },
      error => {
        console.log(error);
      })
  }

  saveVacancy(): void {

    const selectedClient = this.clients.find((client) => { 
      return client.name === this.selectedName;
    })

    const data = {

      title: this.vacancy.title,
      budget: this.vacancy.budget,
      budgetType: this.vacancy.budgetType,
      currency: this.vacancy.currency,
      contractType: this.vacancy.contractType,
      description: this.vacancy.description,
      contact: this.vacancy.contact,
      client: selectedClient,
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
