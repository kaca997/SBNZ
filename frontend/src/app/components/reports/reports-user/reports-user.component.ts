import { Component, OnInit } from '@angular/core';
import { ReportsService } from 'app/services/reports.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-reports-user',
  templateUrl: './reports-user.component.html',
  styleUrls: ['./reports-user.component.css']
})
export class ReportsUserComponent implements OnInit {

  users: Array<any>;
  constructor(private reportsService: ReportsService, private toastr:ToastrService) { }

  ngOnInit(): void {
    this.reportsService.bestUsers().subscribe(
			result => {
        console.log(result);
        this.users = result.users;
        console.log(this.users[0]);
			},
			error => {
				this.toastr.error(error.error);
			}
		);
  }

}
