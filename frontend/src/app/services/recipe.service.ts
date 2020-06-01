import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Credentials': 'true'});
  constructor(
    private http: HttpClient
) { }

addRecipe(recipe: any): Observable<any> {
  let addRecipeURL =  "http://localhost:8080/addRecipe";
  return this.http.post(addRecipeURL, recipe, {headers: this.headers});
  }

searchRecipe(recipeData: any): Observable<any> {
  let searchRecipeURL =  "http://localhost:8080/searchRecipe";
  return this.http.post(searchRecipeURL, recipeData, {headers: this.headers});
  }

searchRecipeByName(recipeData: any): Observable<any> {
  let searchRecipeURL =  "http://localhost:8080/searchRecipeByName";
  return this.http.post(searchRecipeURL, recipeData, {headers: this.headers});
  }
}
