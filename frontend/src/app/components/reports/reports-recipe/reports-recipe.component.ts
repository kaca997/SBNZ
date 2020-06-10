import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReportsService } from 'app/services/reports.service';
import { ToastrService } from 'ngx-toastr';
import { DataService } from 'app/services/data.service';

@Component({
  selector: 'app-reports-recipe',
  templateUrl: './reports-recipe.component.html',
  styleUrls: ['./reports-recipe.component.css']
})
export class ReportsRecipeComponent implements OnInit {
  type:string;
  recipes: Array<any>;
  countRecipes: number = 0;
  constructor(private router: Router, private reportsService: ReportsService, private toastr:ToastrService, private data:DataService) { }

  ngOnInit(): void {
    console.log(this.type);
    const url = this.router.url;
    if(url.includes("least")){
      this.type = "least";
      this.getLeastPopularRecipes();
    }
    else{
      this.type = "best";
      this.getMostPopularRecipes();
    }
    console.log(this.recipes);
  }

  getMostPopularRecipes(){
    this.reportsService.mostPopularRecipes().subscribe(
			result => {
        console.log("Most:",result);
        this.recipes = result.recipes;
        this.countRecipes = this.recipes.length;
			},
			error => {
				this.toastr.error(error.error);
			}
		);
  }

  getLeastPopularRecipes(){
    this.reportsService.leastPopularRecipes().subscribe(
			result => {
        console.log("Least:",result);
        this.recipes = result.recipes;
        this.countRecipes = this.recipes.length;
			},
			error => {
				this.toastr.error(error.error);
			}
		);
  }

  details(recipe){
    this.data.changeRecipeDetails(recipe);
    this.router.navigate(['recipeDetails']);
  }
}
