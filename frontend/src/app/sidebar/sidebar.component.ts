import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'app/services/auth.service';
import { ElementSchemaRegistry } from '@angular/compiler';


export interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
    role : string;
}

export const ROUTES: RouteInfo[] = [
    { path: '/start-page',     title: 'Recipe App',         icon:'nc-bank',       class: '',      role:'' },
    { path: '/notifications', title: 'Notifications',     icon:'nc-bell-55',    class: '',      role:''  },
    { path: '/addRecipe', title: 'Add recipe',     icon:'nc-icon nc-simple-add',    class: '',      role:'ROLE_ADMIN'  },
    { path: '/searchRecipe', title: 'Search recipes',     icon:'nc-icon nc-zoom-split',    class: '',      role:'ROLE_REGISTEREDUSER'  },
    { path: '/mostPopularRecipes', title: 'Most popular recipes',     icon:'fa fa-angle-double-up',    class: '',      role:'ROLE_ADMIN'  },
    { path: '/leastPopularRecipes', title: 'Least popular recipes',     icon:'fa fa-angle-double-down',    class: '',      role:'ROLE_ADMIN'  },
    { path: '/bestUsers', title: 'Best users',     icon:'fa fa-star',    class: '',      role:'ROLE_ADMIN'  },
   ];

@Component({
    moduleId: module.id,
    selector: 'sidebar-cmp',
    templateUrl: 'sidebar.component.html',
})

export class SidebarComponent implements OnInit {
    public menuItems: any[];
    constructor(private authService: AuthenticationService){

    }
    ngOnInit() {
        this.menuItems = ROUTES.filter(menuItem => menuItem)
    }

    checkRole(menuItem): boolean{
        const role = this.authService.getRole();
        if(menuItem.role.includes(role))
            return true;
        else
            return false;
    }
}
