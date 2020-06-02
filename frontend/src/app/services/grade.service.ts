import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GradeService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Credentials': 'true'});
  constructor(
    private http: HttpClient
    ){}
  
  getGrade(recipeData: any): Observable<any> {
    let getGradeURL =  "http://localhost:8080/getGrade";
    return this.http.post(getGradeURL, recipeData, {headers: this.headers});
    }
  }
