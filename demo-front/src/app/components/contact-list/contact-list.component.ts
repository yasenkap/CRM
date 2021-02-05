import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/models/client.model';
import { Contact } from 'src/app/models/contact.model';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {

  contacts?: Contact[];
  currentContact?: Contact;
  currentCompany?: Client;
  currentIndex = -1;
  clientName = '';
  currentCompanyName?: string;

  constructor(private router: Router, private contactService: ContactService) {
    this.currentCompanyName = '';
   }

  ngOnInit(): void {
    this.retrieveContacts();
  }

  retrieveContacts(): void {
    this.contactService.getAll().subscribe(
      data => {
        this.contacts = data;
        console.log(data)
      },
      error => {
        console.log(error);
      })
  }

  refreshList(): void {
    this.retrieveContacts();
    this.currentContact = undefined;
    this.currentCompany = undefined;
    this.currentCompanyName = '';
    this.currentIndex = -1;
  }

  setActiveContact(contact: Contact, index: number): void {
    this.currentContact = contact;
    this.currentIndex = index;

    //this part below does not work :(
    this.currentCompany == this.contactService.getClientByContactId(contact.id);
    const currentCompanyName = this.currentCompany?.name;
    console.log('service ', this.contactService.getClientByContactId(contact.id));
    console.log(this.currentCompany);
    console.log(this.currentCompanyName);
  }

  searchClientName(): void {
    this.contactService.findByClientName(this.clientName).subscribe(
      data => {
        this.contacts = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });

  }

}
