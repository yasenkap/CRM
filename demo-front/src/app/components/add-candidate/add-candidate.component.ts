import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Candidate } from 'src/app/models/candidate.model';
import { CandidateService } from 'src/app/services/candidate.service';

@Component({
  selector: 'app-add-candidate',
  templateUrl: './add-candidate.component.html',
  styleUrls: ['./add-candidate.component.css']
})
export class AddCandidateComponent implements OnInit {

  candidate: Candidate = {
    name: '',
    surname: '',
    phoneNumber: '',
    email: '',
    skillTags: '',
    description: '',
    vacancies: []
  };

  submitted = false;

  constructor(private router: Router, private candidateService: CandidateService) { }

  ngOnInit(): void {

  }

  saveCandidate(): void {
    const data = {
      name: this.candidate.name,
      surname: this.candidate.surname,
      phoneNumber: this.candidate.phoneNumber,
      email: this.candidate.email,
      skillTags: this.candidate.skillTags,
      description: this.candidate.description,
      vacancies: this.candidate.vacancies
    };

    this.candidateService.create(data).subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      });
  }

  newCandidate(): void {
    this.submitted = false;
    this.candidate = {
      name: '',
      surname: '',
      phoneNumber: '',
      email: '',
      skillTags: '',
      description: '',
      vacancies: []
    };
  }

}
