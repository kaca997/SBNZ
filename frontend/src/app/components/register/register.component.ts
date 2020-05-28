import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'app/services/auth.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  formReg: FormGroup;
  likes: Set<string> = new Set();
  hates: Set<string> = new Set();

	constructor(
		private fb: FormBuilder,
		private router: Router,
		private authenticationService: AuthenticationService,
		private toastr: ToastrService
	) {
		this.formReg = this.fb.group({
			firstName: [null, Validators.required],
			lastName: [null, Validators.required],
			username: [null, Validators.required],
			password: [null, Validators.required],
			repeatedPassword: [null, Validators.required],
			like:[null],
			hate:[null],
		});
	}

	ngOnInit() {
	}

  register(){
	const user: any = {};
		user.firstName = this.formReg.value.firstName;
		user.lastName = this.formReg.value.lastName;
		user.username = this.formReg.value.username;
		user.password = this.formReg.value.password;
		Array.from(this.likes.values());
		user.likes = Array.from(this.likes.values());
		user.hates = Array.from(this.hates.values());
		console.log(user);
		const repeatedPassword = this.formReg.value.repeatedPassword;
		if(user.password !== repeatedPassword){
			this.toastr.error("Passwords are not the same");
			return;
		}
		this.authenticationService.register(user).subscribe(
			result => {
				this.toastr.success("Registration successfull");
			},
			error => {
				console.log(error);
				this.toastr.error(error.error);
			}
	  );

  }
  addIngredientLike(){
    this.likes.add(this.formReg.value.like);
    console.log(this.likes);
  }
  addIngredientHate(){
    this.hates.add(this.formReg.value.hate);
    console.log(this.hates);
  }
}
