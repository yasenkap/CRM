import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Client } from 'src/app/models/client.model';
import { ClientService } from 'src/app/services/client.service';


@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  client: Client = {
    name: '',
    description: '',
    website: '',
    city: ''
  };
  submitted = false;

  constructor(private router: Router, private clientService: ClientService) { }

  ngOnInit(): void {
  }

  saveClient(): void {
    const data = {
      name: this.client.name,
      description: this.client.description,
      website: this.client.website,
      city: this.client.city
    };

    this.clientService.create(data).subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      });
  }

  newClient(): void {
    this.submitted = false;
    this.client = {
      name: '',
      description: '',
      website: '',
      city: ''
    };
  }

}
