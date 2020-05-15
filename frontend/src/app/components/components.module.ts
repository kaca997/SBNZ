import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { NavbarComponent } from "./navbar/navbar.component";
import { SidebarComponent } from "./sidebar/sidebar.component";
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [CommonModule, RouterModule, NgbModule,  ReactiveFormsModule],
  declarations: [ NavbarComponent, SidebarComponent, LoginComponent],
  exports: [NavbarComponent, SidebarComponent, LoginComponent]
})
export class ComponentsModule {}
