import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMovieListComponent } from './edit-movie-list.component';

describe('EditMovieListComponent', () => {
  let component: EditMovieListComponent;
  let fixture: ComponentFixture<EditMovieListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditMovieListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditMovieListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
