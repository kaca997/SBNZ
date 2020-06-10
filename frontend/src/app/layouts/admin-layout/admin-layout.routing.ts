import { Routes } from '@angular/router';

import { NotificationsComponent } from '../../pages/notifications/notifications.component';
import { AddRecipeComponent } from 'app/components/recipes/add-recipe/add-recipe.component';
import { SearchRecipeComponent } from 'app/components/recipes/search-recipe/search-recipe.component';
import { MainRecipesComponent } from 'app/components/recipes/main-recipes/main-recipes.component';
import { RecipeDetailsComponent } from 'app/components/recipes/recipe-details/recipe-details.component';
import { ReportsRecipeComponent } from 'app/components/reports/reports-recipe/reports-recipe.component';
import { RoleGuard } from 'app/guards/role-guard.service';
import { ReportsUserComponent } from 'app/components/reports/reports-user/reports-user.component';
import { PrepareRecipeComponent } from 'app/components/recipes/prepare-recipe/prepare-recipe.component';
import { StartPageComponent } from 'app/components/start-page/start-page.component';
import { NewRuleComponent } from 'app/components/new-rule/new-rule.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'notifications',  component: NotificationsComponent },
    { path: 'addRecipe', 
      data: { expectedRoles: 'ROLE_ADMIN' },
      canActivate: [RoleGuard],
      component: AddRecipeComponent },
    { path: 'searchRecipe',
      data: { expectedRoles: 'ROLE_REGISTEREDUSER' },
      canActivate: [RoleGuard],
      component: SearchRecipeComponent },
    { path: 'foundRecipes',
      data: { expectedRoles: 'ROLE_ADMIN|ROLE_REGISTEREDUSER' },
      canActivate: [RoleGuard],
      component: MainRecipesComponent},
    { path: 'recipeDetails',
      data: { expectedRoles: 'ROLE_ADMIN|ROLE_REGISTEREDUSER' },
      canActivate: [RoleGuard],
      component: RecipeDetailsComponent },
    { path: 'prepareRecipe',
      data: { expectedRoles: 'ROLE_REGISTEREDUSER' },
      canActivate: [RoleGuard],
      component: PrepareRecipeComponent },
    { path: 'leastPopularRecipes',
      data: { expectedRoles: 'ROLE_ADMIN' },
      canActivate: [RoleGuard],
      component: ReportsRecipeComponent },
    { path: 'mostPopularRecipes',
      data: { expectedRoles: 'ROLE_ADMIN' },
      canActivate: [RoleGuard],
      component: ReportsRecipeComponent },
      { path: 'bestUsers',
      data: { expectedRoles: 'ROLE_ADMIN' },
      canActivate: [RoleGuard],
      component: ReportsUserComponent },
      { path: 'start-page',
      data: { expectedRoles: 'ROLE_ADMIN|ROLE_REGISTEREDUSER' },
      canActivate: [RoleGuard],
      component:  StartPageComponent},
      { path: 'newRule',
      data: { expectedRoles: 'ROLE_ADMIN' },
      canActivate: [RoleGuard],
      component:  NewRuleComponent},
];
