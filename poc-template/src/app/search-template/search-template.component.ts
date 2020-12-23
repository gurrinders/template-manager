import { Component, OnInit } from '@angular/core';
import { TemplateService } from '../template.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-search-template',
  templateUrl: './search-template.component.html',
  styleUrls: ['./search-template.component.css']
})

export class SearchTemplateComponent implements OnInit {

  alertId : string;
  language : string;
  deliveryType : string;
  id :string;
  baseUrl: string;
  
  //constructor(private http: HttpClient){}

  constructor(private templateService: TemplateService, private http: HttpClient) {  }

  ngOnInit(): void {
    //this.baseUrl ='http://localhost:8080/template-manager-app/api/v1/template/search';
  }

  searchTemplate(){
    console.log("Guri");
    this.templateService.getTemplate(this.deliveryType + '-' + this.alertId + '-' + this.language)
    .subscribe(data => {
      console.log(data)
   //   this.customer = data;
    }, error => console.log(error));;
    //this.id = this.deliveryType + this.alertId + this.language;
    //console.log(this.baseUrl + this.id);
    //this.http.get(this.baseUrl + this.id);
  }
}
