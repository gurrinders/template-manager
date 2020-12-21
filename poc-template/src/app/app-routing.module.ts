import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchTemplateComponent } from '../app/search-template/search-template.component';
import { PreviewTemplateComponent } from '../app/preview-template/preview-template.component';
import { LoginTemplateComponent } from '../app/login-template/login-template.component';

const routes: Routes = [
    { path: 'login', component: LoginTemplateComponent },
    { path: 'searchTemplate', component: SearchTemplateComponent },
    { path: 'previewTemplate', component: PreviewTemplateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
