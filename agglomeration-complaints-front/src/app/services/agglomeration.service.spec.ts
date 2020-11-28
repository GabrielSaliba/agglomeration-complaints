import { TestBed } from '@angular/core/testing';

import { AgglomerationService } from './agglomeration.service';

describe('AgglomerationService', () => {
  let service: AgglomerationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AgglomerationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
