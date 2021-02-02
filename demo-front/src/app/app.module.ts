import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { RestapiService } from './restapi.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddClientComponent } from './components/add-client/add-client.component';
import { ClientDetailsComponent } from './components/client-details/client-details.component';
import { ClientListComponent } from './components/client-list/client-list.component'
import { ClientService } from './services/client.service';
import { CandidateListComponent } from './components/candidate-list/candidate-list.component';
import { AddCandidateComponent } from './components/add-candidate/add-candidate.component';
import { CandidateDetailsComponent } from './components/candidate-details/candidate-details.component';
import { VacancyDetailsComponent } from './components/vacancy-details/vacancy-details.component';
import { VacancyListComponent } from './components/vacancy-list/vacancy-list.component';
import { AddVacancyComponent } from './components/add-vacancy/add-vacancy.component';
import { AddContactComponent } from './components/add-contact/add-contact.component';
import { ContactDetailsComponent } from './components/contact-details/contact-details.component';
import { ContactListComponent } from './components/contact-list/contact-list.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AddClientComponent,
    ClientDetailsComponent,
    ClientListComponent,
    CandidateListComponent,
    AddCandidateComponent,
    CandidateDetailsComponent,
    VacancyDetailsComponent,
    VacancyListComponent,
    AddVacancyComponent,
    AddContactComponent,
    ContactDetailsComponent,
    ContactListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule  
  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
