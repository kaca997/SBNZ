import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { NavbarComponent } from "./navbar/navbar.component";
import { SidebarComponent } from "./sidebar/sidebar.component";
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { SearchRecipeComponent } from './recipes/search-recipe/search-recipe.component';
import { MainRecipesComponent } from './recipes/main-recipes/main-recipes.component';
import { RecipeDetailsComponent } from './recipes/recipe-details/recipe-details.component';
import { ReportsRecipeComponent } from './reports/reports-recipe/reports-recipe.component';
import { AddRecipeComponent } from './recipes/add-recipe/add-recipe.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { ReportsUserComponent } from './reports/reports-user/reports-user.component';
import { PrepareRecipeComponent } from './recipes/prepare-recipe/prepare-recipe.component';
import { StartPageComponent } from './start-page/start-page.component';
import { NewRuleComponent } from './new-rule/new-rule.component';

@NgModule({
  imports: [CommonModule, RouterModule, NgbModule,  ReactiveFormsModule, FormsModule],
  declarations: [ NavbarComponent, SidebarComponent, LoginComponent, AddRecipeComponent, RegisterComponent, SearchRecipeComponent, MainRecipesComponent, RecipeDetailsComponent, ReportsRecipeComponent, ErrorPageComponent, ReportsUserComponent, PrepareRecipeComponent, StartPageComponent, NewRuleComponent],
  exports: [NavbarComponent, SidebarComponent, LoginComponent, AddRecipeComponent, RegisterComponent, SearchRecipeComponent, MainRecipesComponent,ErrorPageComponent,StartPageComponent, NewRuleComponent]
})
export class ComponentsModule {}
