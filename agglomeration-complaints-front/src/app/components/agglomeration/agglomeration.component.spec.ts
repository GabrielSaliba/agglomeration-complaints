import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgglomerationComponent } from './agglomeration.component';

describe('AgglomerationComponent', () => {
  let component: AgglomerationComponent;
  let fixture: ComponentFixture<AgglomerationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgglomerationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AgglomerationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
