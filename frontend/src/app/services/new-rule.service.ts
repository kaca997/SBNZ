import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewRuleService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Credentials': 'true'});
  constructor(
    private http: HttpClient
    ){}
  
  addRule(rule: any): Observable<any> {
    let newRuleURL =  "http://localhost:8080/newRule";
    return this.http.post(newRuleURL, rule, {headers: this.headers, responseType: 'text'});
    }
}
