import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Client } from 'src/app/models/client.model';
import { Contact } from 'src/app/models/contact.model';
import { Vacancy } from 'src/app/models/vacancy.model';
import { ClientService } from 'src/app/services/client.service';
import { ContactService } from 'src/app/services/contact.service';
import { VacancyService } from 'src/app/services/vacancy.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  clients?: Client[];
  currentClient?: Client;
  contacts?: Contact[];
  vacancies?: Vacancy[];
  currentIndex = -1;
  name = '';

  constructor(private router: Router, private clientService: ClientService, private contactService: ContactService, private vacancyService: VacancyService) { }

  ngOnInit(): void {
    this.retrieveClients();
    this.contacts = undefined;
    this.vacancies = undefined;
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

  retrieveContacts(): void {
    this.contactService.findByClientName(this.currentClient?.name).subscribe(
      data => {
        this.contacts = data;
        console.log(data)
      },
      error => {
        console.log(error);
      })
  }
  
  retrieveVacancies(): void {
    this.vacancyService.findByClientName(this.currentClient?.name).subscribe(
      data1 => {
        this.vacancies = data1;
        console.log(data1)
      },
      error => {
        console.log(error);
      })
  }

  refreshList(): void {
    this.retrieveClients();
    this.contacts = undefined;
    this.vacancies = undefined;
    this.currentClient = undefined;
    this.currentIndex = -1;
  }

  setActiveClient(client: Client, index: number): void {
    this.currentClient = client;
    this.currentIndex = index;
    this.retrieveContacts();
    this.retrieveVacancies();
  }

  searchName(): void {
    this.clientService.findByName(this.name).subscribe(
      data => {
        this.clients = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });

  }

}
