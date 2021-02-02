import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Contact } from 'src/app/models/contact.model';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent implements OnInit {

  currentContact: Contact = {
    name: '',
    surname: '',
    email: '',
    phoneNumber: '',
    position: '',
    client: undefined
  };

  message = '';

  constructor(private contactService: ContactService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getContact(this.route.snapshot.params.id);
  }

  getContact(id: string): void {
    this.contactService.get(id)
      .subscribe(
        data => {
          this.currentContact = data;
          console.log(data)
        },
        error => {
          console.log(error);
        });
  }

  updateContact(): void {

    this.contactService.update(this.currentContact.id, this.currentContact)
      .subscribe(response => {
        console.log(response);
        this.message = response.message;
        this.router.navigate(['/contacts']);
      },
        error => {
          console.log(error);
        });
  }

  deleteContact(): void {
    this.contactService.delete(this.currentContact.id)
      .subscribe(response => {
        console.log(response);
        this.router.navigate(['/contacts']);
      },
        error => {
          console.log(error);

        });
  }


}
