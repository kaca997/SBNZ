import { Component, OnInit } from '@angular/core';
import { DataService } from 'app/services/data.service';
import { RecipeService } from 'app/services/recipe.service';
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
  constructor(private data:DataService, private gradeService: GradeService, private toastr: ToastrService, private recipeService:RecipeService) { }

  ngOnInit(): void {
    this.data.recipeDetails.subscribe(recipe => this.recipe = recipe);
    console.log(this.recipe);
    this.recipeService.prepare().subscribe(
      recipe =>{
      console.log("OK");
      },
      error =>{
        console.log(error);
      }
    )
  }

  done(step, index){
    const stepDetails: any = {};
    stepDetails.recipeID = this.recipe.id;
    stepDetails.step = step;
    stepDetails.success = true;
    this.stepsDone.push(stepDetails);
    this.count = this.count+1;
    console.log(this.stepsDone);
    this.recipeService.newStep(stepDetails).subscribe(
			result => {
        console.log("AAAAAAAA");
        console.log(result);
			},
			error => {
        console.log("ERRRRR");
				console.log(error);
      })
  }

  fail(step, index){
    const stepDetails: any = {};
    stepDetails.recipeID = this.recipe.id;
    stepDetails.step = step;
    stepDetails.success = false;
    this.stepsDone.push(stepDetails);
    this.count += 1;
    console.log(this.stepsDone);
    this.recipeService.newStep(stepDetails).subscribe(
			result => {
        console.log(result);
			},
			error => {
				console.log(error);
      })
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
