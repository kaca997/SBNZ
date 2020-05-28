import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private recipesData = new BehaviorSubject(Array<any>());
  recipes = this.recipesData.asObservable();

  private recipeDetailsData = new BehaviorSubject(null);
  recipeDetails = this.recipeDetailsData.asObservable();

  constructor() { }

  changeRecipes(recipes: Array<any>) {
    this.recipesData.next(recipes);
  }

  changeRecipeDetails(recipeDetails: any) {
    this.recipeDetailsData.next(recipeDetails);
  }
}
