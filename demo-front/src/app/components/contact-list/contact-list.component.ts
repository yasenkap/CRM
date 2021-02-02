import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  currentIndex = -1;
  companyName = '';

  constructor(private router: Router, private contactService: ContactService) { }

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
    this.currentIndex = -1;
  }

  setActiveContact(contact: Contact, index: number): void {
    this.currentContact = contact;
    this.currentIndex = index;
  }

  ///check if works
  searchClientName(): void {
    this.contactService.findByClientName(this.currentContact?.client?.name).subscribe(
      data => {
        this.contacts = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });

  }

}
