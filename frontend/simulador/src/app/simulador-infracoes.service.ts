import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SimuladorInfracoesService {
  private baseUrl = 'http://localhost:8085';
  constructor(private http: HttpClient) { }

  startLoop(): Observable<any> {
    return this.http.get(`${this.baseUrl}/api/central/iniciarLoop`);
  }

  stopLoop(): Observable<any> {
    return this.http.get(`${this.baseUrl}/api/central/pararLoop`);
  }

  consultarBanco(): Observable<any> {
    return this.http.get(`${this.baseUrl}/api/central`);
  }
}
