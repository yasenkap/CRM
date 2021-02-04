import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Candidate } from 'src/app/models/candidate.model';
import { CandidateService } from 'src/app/services/candidate.service';

@Component({
  selector: 'app-candidate-list',
  templateUrl: './candidate-list.component.html',
  styleUrls: ['./candidate-list.component.css']
})
export class CandidateListComponent implements OnInit {

  candidates?: Candidate[];
  currentCandidate?: Candidate;
  currentIndex = -1;
  surname = '';

  constructor(private router: Router, private candidateService: CandidateService) { }

  ngOnInit(): void {
    this.retrieveCandidates();
  }

  retrieveCandidates(): void {
    this.candidateService.getAll().subscribe(
      data => {
        this.candidates = data;
        console.log(data)
      },
      error => {
        console.log(error);
      })
  }

  refreshList(): void {
    this.retrieveCandidates();
    this.currentCandidate = undefined;
    this.currentIndex = -1;
  }

  setActiveCandidate(candidate: Candidate, index: number): void {
    this.currentCandidate= candidate;
    this.currentIndex = index;
  }

  searchSurname(): void {
    this.candidateService.findBySurname(this.surname).subscribe(
      data => {
        this.candidates = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });

  }

}
