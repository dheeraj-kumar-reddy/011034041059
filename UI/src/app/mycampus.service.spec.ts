import { TestBed } from '@angular/core/testing';

import { MycampusService } from './mycampus.service';

describe('MycampusService', () => {
  let service: MycampusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MycampusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
