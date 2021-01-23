import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Client } from 'src/app/models/client.model';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  clients?: Client[];
  currentClient?: Client;
  currentIndex = -1;
  name = '';

  constructor(private router: Router, private clientService: ClientService) { }

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

  refreshList(): void {
    this.retrieveClients();
    this.currentClient = undefined;
    this.currentIndex = -1;
  }

  setActiveClient(client: Client, index: number): void {
    this.currentClient = client;
    this.currentIndex = index;
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
