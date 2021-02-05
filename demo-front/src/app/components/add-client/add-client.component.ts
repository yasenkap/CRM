import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Key } from 'protractor';

import { City, Client } from 'src/app/models/client.model';
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
    city: undefined,
  };
  submitted = false;

  city = City;
  selectedCity: string;

    keys() : Array<string> {
       return Object.keys(this.city);
    }

    values() : Array<string> {
      return Object.values(this.city);
   }

  constructor(private router: Router, private clientService: ClientService) {
    this.selectedCity = '';
   }

  ngOnInit(): void {
  }

  

  saveClient(): void {
   //const selectedCity = Object.keys(this.city).find(key => this.city[key] === this.client.city);

    console.log('selected city: ', this.client.city)
    const data = {
      name: this.client.name,
      description: this.client.description,
      website: this.client.website,
      city: this.client.city
     //city: City[this.client.city]
      //city: Object.keys(City)[Object.values(City).indexOf(this.client.city)],
    }


    console.log('selected city: ', this.client.city)
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
      city: undefined
    };
  }

}
