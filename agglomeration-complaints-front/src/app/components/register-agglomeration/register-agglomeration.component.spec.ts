import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterAgglomerationComponent } from './register-agglomeration.component';

describe('RegisterAgglomerationComponent', () => {
  let component: RegisterAgglomerationComponent;
  let fixture: ComponentFixture<RegisterAgglomerationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterAgglomerationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterAgglomerationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
