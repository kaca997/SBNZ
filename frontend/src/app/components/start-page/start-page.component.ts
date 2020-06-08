import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'app/services/auth.service';

@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
  styleUrls: ['./start-page.component.css']
})
export class StartPageComponent implements OnInit {

  username = "";
  constructor(private auth: AuthenticationService) { }

  ngOnInit(): void {
    this.username = this.auth.getUsername()
  }

}
