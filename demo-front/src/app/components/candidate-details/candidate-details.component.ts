import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Candidate } from 'src/app/models/candidate.model';
import { CandidateService } from 'src/app/services/candidate.service';

@Component({
  selector: 'app-candidate-details',
  templateUrl: './candidate-details.component.html',
  styleUrls: ['./candidate-details.component.css']
})
export class CandidateDetailsComponent implements OnInit {

  currentCandidate: Candidate = {
    name: '',
    surname: '',
    phoneNumber: '',
    email: '',
    skillTags: '',
    description: ''
  }

  message = '';

  constructor(
    private candidateService: CandidateService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getCandidate(this.route.snapshot.params.id);
  }

  getCandidate(id: string): void {
    this.candidateService.get(id)
      .subscribe(
        data => {
          this.currentCandidate = data;
          console.log(data)
        },
        error => {
          console.log(error);
        });
  }

  updateCandidate(): void {

    this.candidateService.update(this.currentCandidate.id, this.currentCandidate)
      .subscribe(response => {
        console.log(response);
        this.router.navigate(['/candidates']);
        this.message = response.message;
      },
        error => {
          console.log(error);
        });
  }

  deleteCandidate(): void {
    this.candidateService.delete(this.currentCandidate.id)
      .subscribe(response => {
        console.log(response);
        this.router.navigate(['/candidates']);
      },
        error => {
          console.log(error);

        });
  }
}
