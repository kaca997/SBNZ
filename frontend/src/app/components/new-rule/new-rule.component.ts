import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NewRuleService } from 'app/services/new-rule.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-rule',
  templateUrl: './new-rule.component.html',
  styleUrls: ['./new-rule.component.css']
})
export class NewRuleComponent implements OnInit {

  ruleForm: FormGroup;

  constructor(private fb: FormBuilder, private ruleService: NewRuleService, private toastr: ToastrService, private router : Router) { 
    this.ruleForm = this.fb.group({
      ruleName : [null, Validators.required],
      salienceVal : [null, [Validators.required, Validators.pattern("-?[0-9]+")]],
      gradeCount: [null,  [Validators.required, Validators.pattern("[0-9]+")]],
      gradeValue: [null,  [Validators.required, Validators.pattern("[1-5]")]],
      previousUserType: [null, Validators.required],
      newUserType:  [null, Validators.required],
      recipeComplexityType: [null, Validators.required],
    });
  }

  ngOnInit(): void {
  }

  newRule(){
    const rule: any = {};
    rule.ruleName = this.ruleForm.value.ruleName;
    rule.salienceVal = this.ruleForm.value.salienceVal;
		rule.gradesCount = this.ruleForm.value.gradeCount;
    rule.largerThenGrade = this.ruleForm.value.gradeValue;
    rule.previousType = this.ruleForm.value.previousUserType;
    rule.newType = this.ruleForm.value.newUserTypel;
    rule.recipeType = this.ruleForm.value.recipeComplexityType;
    console.log(rule);
    this.ruleService.addRule(rule).subscribe(
			result => {
        this.toastr.success("Rule added successfully!");
        this.router.navigate['start-page'];
				console.log(result);
			},
			error => {
				console.log(error);
        this.toastr.error(error.error);
      }
    )
  }

}
