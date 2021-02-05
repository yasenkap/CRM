import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Client } from 'src/app/models/client.model';
import { Contact } from 'src/app/models/contact.model';
import { ClientService } from 'src/app/services/client.service';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  clients?: Client[];
  currentClient?: Client;
  contacts?: Contact[];
  currentIndex = -1;
  name = '';

  constructor(private router: Router, private clientService: ClientService, private contactService: ContactService) { }

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

  refreshList(): void {
    this.retrieveClients();
    this.retrieveContacts();
    this.currentClient = undefined;
    this.currentIndex = -1;
  }

  setActiveClient(client: Client, index: number): void {
    this.currentClient = client;
    this.currentIndex = index;
    this.retrieveContacts();
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
