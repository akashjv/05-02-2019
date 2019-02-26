import { TestBed } from '@angular/core/testing';

import { LeavehistoryService } from './leavehistory.service';

describe('LeavehistoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LeavehistoryService = TestBed.get(LeavehistoryService);
    expect(service).toBeTruthy();
  });
});
