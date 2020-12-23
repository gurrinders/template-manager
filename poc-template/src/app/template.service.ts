import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class TemplateService {

  private baseUrl = 'http://localhost:8080/template-manager-app/api/v1/template/search/';

  constructor(private http: HttpClient) { }

  getTemplate(id: string): Observable<any>  {
    return this.http.get(this.baseUrl + id);
  }
  
  // createTemplate(template: Object) : Observable<Object>{
  //   //return this.http.get(this.baseUrl, template);
  // }

  // updateTemplate(id: string, value: any) : Observable<Object>{
  //   //return this.http.put(this.baseUrl + id, value);
  // }

  // deleteTemplate(id: string) : Observable<Object> {
  //  // return this.http.delete(this.baseUrl + id, { responseType: 'text' });
  // }
}
