import { TestBed } from '@angular/core/testing';

import { ClientWsService } from './client-ws.service';

describe('ClientWsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ClientWsService = TestBed.get(ClientWsService);
    expect(service).toBeTruthy();
  });
});
