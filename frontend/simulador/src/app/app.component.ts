import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  public isLoopRunning = false;

  constructor(private http: HttpClient) {}

    dados: any[] = [];

  public startLoop(): void {
    this.http.get('/api/central/iniciarLoop', {}).subscribe(() => {
      this.isLoopRunning = true;
    });
  }

  public stopLoop(): void {
    this.http.get('/api/central/pararLoop', {}).subscribe(() => {
      this.isLoopRunning = false;
    });
  }

  public consultarBanco(): void {
    this.http.get('/api/central').subscribe((response: any) => {
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