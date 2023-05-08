import { Component, OnInit } from '@angular/core';
import { SimuladorInfracoesService } from '../simulador-infracoes.service';
import Swal from 'sweetalert2';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-simulador-infracoes',
  templateUrl: './simulador-infracoes.component.html',
  styleUrls: ['./simulador-infracoes.component.css']
})

export class SimuladorInfracoesComponent implements OnInit {

  constructor(private simuladorService: SimuladorInfracoesService, private http: HttpClient) {
    this.atualizarDados();
   }

  dados: any[] = [];

  ngOnInit(): void {
  }

  startLoop() {
    this.simuladorService.stopLoop().subscribe(() => {
      console.log('Loop iniciado');
    });
      Swal.fire({
        title: 'Loop iniciado!',
        icon: 'success',
        timer: 2000,
        timerProgressBar: true,
        toast: true,
        position: 'top-right'
      });
  }

  stopLoop() {
    this.simuladorService.stopLoop().subscribe(() => {
      console.log('Loop parado');
    });
    Swal.fire({
      title: 'Loop parado!',
      icon: 'warning',
      timer: 2000,
      timerProgressBar: true,
      toast: true,
      position: 'top-right'
    });
  }

  consultarBanco() {
    this.simuladorService.consultarBanco()
      .subscribe((response: any) => {
        this.dados = response;
      });
  }

  atualizarDados() {
    this.consultarBanco();
    setTimeout(() => {
      this.atualizarDados();
    }, 5000);
  }
}
