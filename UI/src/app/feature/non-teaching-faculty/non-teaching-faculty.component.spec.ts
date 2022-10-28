import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NonTeachingFacultyComponent } from './non-teaching-faculty.component';

describe('NonTeachingFacultyComponent', () => {
  let component: NonTeachingFacultyComponent;
  let fixture: ComponentFixture<NonTeachingFacultyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NonTeachingFacultyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NonTeachingFacultyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
