import { Component, OnInit } from '@angular/core';
import { SimuladorInfracoesService } from '../simulador-infracoes.service';

@Component({
  selector: 'app-simulador-infracoes',
  templateUrl: './simulador-infracoes.component.html',
  styleUrls: ['./simulador-infracoes.component.css']
})
export class SimuladorInfracoesComponent implements OnInit {

  constructor(private simuladorService: SimuladorInfracoesService) { }

  ngOnInit(): void {
  }

  startLoop(): void {
    this.simuladorService.startLoop().subscribe(() => {
      console.log('Loop iniciado');
    });
  }

  stopLoop(): void {
    this.simuladorService.stopLoop().subscribe(() => {
      console.log('Loop parado');
    });
  }

  consultarBanco(): void {
    this.simuladorService.consultarBanco().subscribe((data) => {
      console.log(data);
    });
  }

}
