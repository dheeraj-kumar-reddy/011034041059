import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeachingFacultyComponent } from './teaching-faculty.component';

describe('TeachingFacultyComponent', () => {
  let component: TeachingFacultyComponent;
  let fixture: ComponentFixture<TeachingFacultyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeachingFacultyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TeachingFacultyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
