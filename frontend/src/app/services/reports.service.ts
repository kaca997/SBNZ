import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportsService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Credentials': 'true'});
  constructor(
    private http: HttpClient
  ) { }

  mostPopularRecipes(): Observable<any> {
    let mostPopularRecipesURL =  "http://localhost:8080/bestRecipes";
    return this.http.get(mostPopularRecipesURL, {headers: this.headers});
    }

  leastPopularRecipes(): Observable<any> {
    let leastPopularRecipesURL =  "http://localhost:8080/leastPopularRecipes";
    return this.http.get(leastPopularRecipesURL, {headers: this.headers});
    }

  bestUsers(): Observable<any> {
    let bestUsersURL =  "http://localhost:8080/bestUsers";
    return this.http.get(bestUsersURL, {headers: this.headers});
    }
}
