import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private recipesData = new BehaviorSubject(Array<any>());
  recipes = this.recipesData.asObservable();

  private bestRecipesData = new BehaviorSubject(Array<any>());
  bestRecipes = this.bestRecipesData.asObservable();

  private notForPreparationData = new BehaviorSubject(Array<any>());
  notForPreparation = this.notForPreparationData.asObservable();

  private recipeDetailsData = new BehaviorSubject(null);
  recipeDetails = this.recipeDetailsData.asObservable();

  constructor() { }

  changeRecipes(recipes: Array<any>) {
    this.recipesData.next(recipes);
  }

  changeBestRecipes(bestRecipes: Array<any>) {
    this.bestRecipesData.next(bestRecipes);
  }

  changeNotForPreparationRecipes(notForPrep: Array<any>) {
    this.notForPreparationData.next(notForPrep);
  }

  changeRecipeDetails(recipeDetails: any) {
    this.recipeDetailsData.next(recipeDetails);
  }
}
