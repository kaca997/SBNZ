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
  ingredients: Set<string> = new Set();
  steps: Set<string> = new Set();
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
      price: [null, [Validators.required, Validators.min(0)]],
      time: [null, [Validators.required, Validators.pattern("[0-9]+")]],
      ingredient:[null],
      step:[null],
      image: [null, Validators.required],
		});
	}

	ngOnInit() {
	}

	addRecipe() {
		const recipe: any = {};
		recipe.name = (this.formAddRecipe.value.name).toLowerCase();
    recipe.type = this.formAddRecipe.value.type;
    recipe.price = this.formAddRecipe.value.price;
    recipe.time = this.formAddRecipe.value.time;
    recipe.ingredients = Array.from(this.ingredients.values());
    recipe.steps =  Array.from(this.steps.values());
    recipe.image = this.formAddRecipe.value.image;
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
    this.ingredients.add((this.formAddRecipe.value.ingredient).toLowerCase());
    console.log(this.ingredients);
    this.noIngredients = false;
  }

  removeIngredient(ingr){
    this.ingredients.delete(ingr);
    console.log(this.ingredients);
  }
  addStep(){
    this.steps.add((this.formAddRecipe.value.step).toLowerCase());
    this.noSteps = false;
    console.log(this.ingredients);
  }

  removeStep(step){
    this.steps.delete(step);
    console.log(this.steps);
  }
}
