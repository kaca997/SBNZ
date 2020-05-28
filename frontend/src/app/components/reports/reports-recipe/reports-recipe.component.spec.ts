import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportsRecipeComponent } from './reports-recipe.component';

describe('ReportsRecipeComponent', () => {
  let component: ReportsRecipeComponent;
  let fixture: ComponentFixture<ReportsRecipeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportsRecipeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportsRecipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
