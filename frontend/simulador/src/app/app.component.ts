import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public isLoopRunning = false;

  constructor(private http: HttpClient) {}

  public startLoop(): void {
    this.http.post('/infracoes/simulador/start', {}).subscribe(() => {
      this.isLoopRunning = true;
    });
  }

  public stopLoop(): void {
    this.http.post('/infracoes/simulador/stop', {}).subscribe(() => {
      this.isLoopRunning = false;
    });
  }

  public consultarBanco(): void {
    this.http.get('/infracoes').subscribe((response: any) => {
      console.log(response);
    });
  }
}