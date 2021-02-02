import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientListComponent } from './components/client-list/client-list.component';
import { ClientDetailsComponent } from './components/client-details/client-details.component';
import { AddClientComponent } from './components/add-client/add-client.component';
import { AddContactComponent } from './components/add-contact/add-contact.component';
import { ContactDetailsComponent } from './components/contact-details/contact-details.component';
import { ContactListComponent } from './components/contact-list/contact-list.component';
import { AddVacancyComponent } from './components/add-vacancy/add-vacancy.component';
import { AddCandidateComponent } from './components/add-candidate/add-candidate.component';
import { CandidateDetailsComponent } from './components/candidate-details/candidate-details.component';
import { CandidateListComponent } from './components/candidate-list/candidate-list.component';
import { VacancyDetailsComponent } from './components/vacancy-details/vacancy-details.component';
import { VacancyListComponent } from './components/vacancy-list/vacancy-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'clients', pathMatch: 'full' },
  { path: 'clients', component: ClientListComponent },
  { path: 'clients/:id', component: ClientDetailsComponent },
  { path: 'addClient', component: AddClientComponent },
  { path: 'contacts', component: ContactListComponent },
  { path: 'contacts/:id', component: ContactDetailsComponent },
  { path: 'addContact', component: AddContactComponent },
  { path: 'vacancies', component: VacancyListComponent },
  { path: 'vacancies/:id', component: VacancyDetailsComponent },
  { path: 'addVacancy', component: AddVacancyComponent },
  { path: 'candidates', component: CandidateListComponent },
  { path: 'candidates/:id', component: CandidateDetailsComponent },
  { path: 'addCandidate', component: AddCandidateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
