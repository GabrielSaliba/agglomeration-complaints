import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ButtonModule} from 'primeng/button';
import {HttpClientModule} from '@angular/common/http';
import {DataViewModule} from 'primeng/dataview';
import {TableModule} from 'primeng/table';
import {AgglomerationComponent} from './components/agglomeration/agglomeration.component';
import { RegisterAgglomerationComponent } from './components/register-agglomeration/register-agglomeration.component';
import {DropdownModule} from 'primeng/dropdown';
import {FormsModule} from '@angular/forms';
import {FileUploadModule} from 'primeng/fileupload';

@NgModule({
  declarations: [
    AppComponent,
    AgglomerationComponent,
    RegisterAgglomerationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    HttpClientModule,
    DataViewModule,
    TableModule,
    DropdownModule,
    FormsModule,
    FileUploadModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
