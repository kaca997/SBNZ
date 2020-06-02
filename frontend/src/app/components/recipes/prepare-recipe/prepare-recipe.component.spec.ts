import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrepareRecipeComponent } from './prepare-recipe.component';

describe('PrepareRecipeComponent', () => {
  let component: PrepareRecipeComponent;
  let fixture: ComponentFixture<PrepareRecipeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrepareRecipeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrepareRecipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
