import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormArray, FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { RecipeService } from 'app/services/recipe.service';
import { DataService } from 'app/services/data.service';

@Component({
  selector: 'app-search-recipe',
  templateUrl: './search-recipe.component.html',
  styleUrls: ['./search-recipe.component.css']
})
export class SearchRecipeComponent implements OnInit {

  formSearchRecipes: FormGroup;
  ingredients: Array<string> = [];
  allTypes: Array<any> = [
    { name: 'Salad', value: 'SALAD' },
    { name: 'Side dish', value: 'SIDE_DISH' },
    { name: 'Main dish', value: 'MAIN' },
    { name: 'Dessert', value: 'DESSERT' }
  ]

	constructor(
		private fb: FormBuilder,
		private router: Router,
    private toastr: ToastrService,
    private recipeService: RecipeService,
    private dataService: DataService,
	) {
		this.formSearchRecipes = this.fb.group({
      price: [null, Validators.required],
      time: [null, Validators.required],
      ingredient:[null],
      recipeType: this.fb.array([])
		});
	}

	ngOnInit() {
  }
  
  onCheckboxChange(e) {
    const checkArray: FormArray = this.formSearchRecipes.get('recipeType') as FormArray;
  
    if (e.target.checked) {
      checkArray.push(new FormControl(e.target.value));
    } else {
      let i: number = 0;
      checkArray.controls.forEach((item: FormControl) => {
        if (item.value == e.target.value) {
          checkArray.removeAt(i);
          return;
        }
        i++;
      });
    }
  }

  searchRecipes() {
		const recipe: any = {};
    recipe.price = this.formSearchRecipes.value.price;
    recipe.time = this.formSearchRecipes.value.time;
    recipe.ingredients = this.ingredients;
    recipe.types = this.formSearchRecipes.value.recipeType;
    console.log(recipe);
    this.recipeService.searchRecipe(recipe).subscribe(
			result => {
        //this.toastr.success("Success");
        console.log("result",result.recipes);
        this.dataService.changeRecipes(result.recipes);
        this.router.navigate(['foundRecipes']);
			},
			error => {
				console.log(error);
        this.toastr.error(error.error);
      }
    )
  }
  addIngredient(){
    this.ingredients.push(this.formSearchRecipes.value.ingredient);
    console.log(this.ingredients);
  }
}
