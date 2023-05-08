import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SimuladorInfracoesComponent } from './simulador-infracoes/simulador-infracoes.component';

const routes: Routes = [
  { path: '', component: SimuladorInfracoesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }