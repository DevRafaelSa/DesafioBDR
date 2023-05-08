import { TestBed } from '@angular/core/testing';

import { SimuladorInfracoesService } from './simulador-infracoes.service';

describe('SimuladorInfracoesService', () => {
  let service: SimuladorInfracoesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SimuladorInfracoesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
