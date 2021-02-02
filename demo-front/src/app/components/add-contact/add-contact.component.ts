import { Component, OnInit } from '@angular/core';
import { Contact } from 'src/app/models/contact.model';
import { Router } from '@angular/router';
import { ContactService } from 'src/app/services/contact.service';
import { ClientService } from 'src/app/services/client.service';
import { Client } from 'src/app/models/client.model';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent implements OnInit {

  contact: Contact = {
    name: '',
    surname: '',
    email: '',
    phoneNumber: '',
    position: '',
    client: undefined
  };

  clients: Client[];

  selectedName: string;

  submitted = false;

  constructor(private router: Router, private contactService: ContactService, private clientService: ClientService) {
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

  saveContact(): void {
    
    const selectedClient = this.clients.find((client) => { 
      return client.name === this.selectedName;
    })

    const data = {
      name: this.contact.name,
      surname: this.contact.surname,
      email: this.contact.email,
      phoneNumber: this.contact.phoneNumber,
      position: this.contact.position,
      client: selectedClient
    };

    this.contactService.create(data).subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      });
  }

  newContact(): void {
    this.submitted = false;
    this.contact = {
      name: '',
      surname: '',
      email: '',
      phoneNumber: '',
      position: '',
      client: undefined
    };
  }

}
