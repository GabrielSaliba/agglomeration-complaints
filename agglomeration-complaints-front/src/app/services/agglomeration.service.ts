import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Agglomeration} from '../models/agglomeration';
import {ConstantUtils} from './constant-utils';

@Injectable({
  providedIn: 'root'
})
export class AgglomerationService {

  url = ConstantUtils.URL + '/agglomeration';
  constructor(private httpClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getAgglomerations(): Observable<Agglomeration[]> {
    return this.httpClient.get<Agglomeration[]>(this.url);
  }

  deleteAgglomeration(id: number): Observable<Agglomeration[]> {
    return this.httpClient.delete<Agglomeration[]>(this.url + '/delete/' + id);
  }

  saveAgglomeration(agglomeration: Agglomeration): Observable<Agglomeration> {
    return this.httpClient.post<Agglomeration>(this.url + '/create', JSON.stringify(agglomeration), this.httpOptions);
  }

  updateAgglomeration(agglomeration: Agglomeration): Observable<Agglomeration> {
    return this.httpClient.put<Agglomeration>(this.url + '/update', JSON.stringify(agglomeration), this.httpOptions);
  }

  postFile(fileToUpload: File): Observable<number[]> {
    const formData: FormData = new FormData();
    formData.append('file', fileToUpload, 'asd');
    console.log(fileToUpload);
    console.log(formData);
    const headers = new HttpHeaders({ 'Content-Type': 'multipart/form-data' });
    return this.httpClient.post<number[]>(ConstantUtils.URL + '/image/upload', formData, {headers});
  }

  sendFormData(formData): any {return this.httpClient.post<any>(ConstantUtils.URL + '/image/upload', formData, {
    reportProgress: true,
    observe: 'events'
  });
  }
}
