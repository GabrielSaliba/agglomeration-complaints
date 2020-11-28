import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AgglomerationComponent} from './components/agglomeration/agglomeration.component';
import {RegisterAgglomerationComponent} from './components/register-agglomeration/register-agglomeration.component';

const routes: Routes = [
  { path: 'agglomerations', component: AgglomerationComponent },
  { path: 'register-agglomeration', component: RegisterAgglomerationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
