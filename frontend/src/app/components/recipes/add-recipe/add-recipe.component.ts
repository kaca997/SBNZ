import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { RecipeService } from 'app/services/recipe.service';

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {

  formAddRecipe: FormGroup;
  ingredients: Array<string> = [];
  steps: Array<string> = [];
  stepCnt: number = 0;
  noSteps: boolean = true;
  noIngredients: boolean = true;

	constructor(
		private fb: FormBuilder,
		private router: Router,
    private toastr: ToastrService,
    private recipeService: RecipeService
	) {
		this.formAddRecipe = this.fb.group({
			name: [null, Validators.required],
      type: [null, Validators.required],
      price: [null, Validators.required],
      time: [null, Validators.required],
      ingredient:[null],
      step:[null],
		});
	}

	ngOnInit() {
	}

	addRecipe() {
		const recipe: any = {};
		recipe.name = this.formAddRecipe.value.name;
    recipe.type = this.formAddRecipe.value.type;
    recipe.price = this.formAddRecipe.value.price;
    recipe.time = this.formAddRecipe.value.time;
    recipe.ingredients = this.ingredients;
    recipe.steps = this.steps;
    console.log(recipe);
    this.recipeService.addRecipe(recipe).subscribe(
			result => {
        this.toastr.success("Recipe added");
				console.log(result);
			},
			error => {
				console.log(error);
        this.toastr.error(error.error);
      }
    )
  }
  addIngredient(){
    this.ingredients.push(this.formAddRecipe.value.ingredient);
    console.log(this.ingredients);
    this.noIngredients = false;
  }
  addStep(){
    this.stepCnt = this.stepCnt+1;
    this.steps.push(this.formAddRecipe.value.step);
    this.noSteps = false;
    console.log(this.ingredients);
  }
}
