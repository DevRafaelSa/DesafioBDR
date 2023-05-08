import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimuladorInfracoesComponent } from './simulador-infracoes.component';

describe('SimuladorInfracoesComponent', () => {
  let component: SimuladorInfracoesComponent;
  let fixture: ComponentFixture<SimuladorInfracoesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SimuladorInfracoesComponent]
    });
    fixture = TestBed.createComponent(SimuladorInfracoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
