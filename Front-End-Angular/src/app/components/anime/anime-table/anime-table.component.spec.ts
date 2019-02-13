import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimeTableComponent } from './anime-table.component';

describe('AnimeTableComponent', () => {
  let component: AnimeTableComponent;
  let fixture: ComponentFixture<AnimeTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnimeTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnimeTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
