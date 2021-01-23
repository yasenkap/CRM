import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../../restapi.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // userName: string;
  // password: string;
  // message: any

  constructor(private service: RestapiService) { }

  ngOnInit(): void {
  }

}
