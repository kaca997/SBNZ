import { Component, OnInit } from '@angular/core';
import { DataService } from 'app/services/data.service';
import { AuthenticationService } from 'app/services/auth.service';
import { GradeService } from 'app/services/grade.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-prepare-recipe',
  templateUrl: './prepare-recipe.component.html',
  styleUrls: ['./prepare-recipe.component.css']
})
export class PrepareRecipeComponent implements OnInit {
  stepsDone: Array<any>=[];
  recipe: any;
  count: number = 0;
  constructor(private data:DataService, private gradeService: GradeService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.data.recipeDetails.subscribe(recipe => this.recipe = recipe);
    console.log(this.recipe);
  }

  done(step, index){
    const stepDetails: any = {};
    stepDetails.number = index;
    stepDetails.step = step;
    stepDetails.success = true;
    this.stepsDone.push(stepDetails);
    this.count = this.count+1;
    console.log(this.stepsDone)
  }

  fail(step, index){
    const stepDetails: any = {};
    stepDetails.number = index;
    stepDetails.step = step;
    stepDetails.success = false;
    this.stepsDone.push(stepDetails);
    this.count += 1;
    console.log(this.stepsDone)
  }
  recipeDone(){
    const recipeData: any = {};
    recipeData.steps = this.stepsDone; 
    recipeData.recipeID = this.recipe.id;
    console.log(recipeData);
    this.gradeService.getGrade(recipeData).subscribe(
			result => {
        const message = "Your grade for this recipe is: "+  result.grade;
        this.toastr.success(message);
			},
			error => {
				console.log(error);
        this.toastr.error(error.error);
      }
    )
  }
}
