import { Component, OnInit } from '@angular/core';
import { DataService } from 'app/services/data.service';
import { AuthenticationService } from 'app/services/auth.service';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  recipe: any;
  constructor(private data:DataService, private authService: AuthenticationService) { }

  ngOnInit(): void {
    this.data.recipeDetails.subscribe(recipe => this.recipe = recipe);
    console.log(this.recipe);
  }

}
