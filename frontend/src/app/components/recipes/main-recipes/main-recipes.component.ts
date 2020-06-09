import { Component, OnInit } from '@angular/core';
import { DataService } from 'app/services/data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-recipes',
  templateUrl: './main-recipes.component.html',
  styleUrls: ['./main-recipes.component.css']
})
export class MainRecipesComponent implements OnInit {

  recipes: Array<any> = [];
  bestRecipes: Array<any> = [];
  notForPreparation : Array<any> = [];
  countRecipes: number= 0;
  countBestRecipes: number =0;
  countNotForPrep: number =0;
  constructor(private data: DataService, private router: Router) { }

  ngOnInit() {
    this.data.recipes.subscribe(recipes => this.recipes = recipes)
    this.data.bestRecipes.subscribe(bestRecipes => this.bestRecipes = bestRecipes)
    this.data.notForPreparation.subscribe(notForPreparation => this.notForPreparation = notForPreparation)
    console.log("OUI")
    console.log(this.recipes);
    console.log("BEST", this.bestRecipes);
    this.countRecipes = this.recipes.length;
    this.countBestRecipes = this.bestRecipes.length;
    this.countNotForPrep = this.notForPreparation.length;
    console.log("NOT FOR PREP",this.notForPreparation);
    // this.recipes = [{id: 2, name: "Recipe2", type: "SIDE_DISH", complexity: "MEDIUM", price: 2, time: 50}];

  }

  details(recipe){
    this.data.changeRecipeDetails(recipe);
    this.router.navigate(['recipeDetails']);
  }
}
