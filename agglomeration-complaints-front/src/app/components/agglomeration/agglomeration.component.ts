import {Component, OnInit} from '@angular/core';
import {Agglomeration} from '../../models/agglomeration';
import {AgglomerationService} from '../../services/agglomeration.service';
import {NgForm} from '@angular/forms';
import {Location} from '../../models/location';
import {Image} from '../../models/image';

@Component({
  selector: 'app-agglomeration',
  templateUrl: './agglomeration.component.html',
  styleUrls: ['./agglomeration.component.css']
})
export class AgglomerationComponent implements OnInit {

  agglomeration = {} as Agglomeration;
  agglomerations: Agglomeration[];
  image = {} as Image;
  fileToUpload: File = null;
  location = {} as Location;
  showEdit = false;
  pageRef = window.location.href;

  constructor(private agglomerationService: AgglomerationService) {
  }

  ngOnInit(): void {
    this.getAgglomerations();
  }

  getAgglomerations(): void {
    this.agglomerationService.getAgglomerations().subscribe((agglomerations: Agglomeration[]) => {
      this.agglomerations = agglomerations;
    });
  }

  delete(id: number): void {
    this.agglomerationService.deleteAgglomeration(id).subscribe(() => {
      this.getAgglomerations();
    });
  }

  editAgglomeration(agglomeration: Agglomeration): void {
    this.showEdit = true;
    console.log(agglomeration);
    this.agglomeration = { ...agglomeration };
    this.location = { ...agglomeration.location};
  }

  saveAgglomeration(form: NgForm): void {
    this.agglomeration.image = this.image;
    this.agglomeration.location = this.location;
    console.log(this.agglomeration);
    if (this.agglomeration.id !== undefined) {
      this.agglomerationService.updateAgglomeration(this.agglomeration).subscribe(() => {
        this.cleanForm(form);
        this.getAgglomerations();
      });
    } else {
      this.agglomerationService.saveAgglomeration(this.agglomeration).subscribe(() => {
        this.cleanForm(form);
        this.getAgglomerations();
      });
    }
  }

  cleanForm(form: NgForm): void {
    form.resetForm();
    this.showEdit = false;
    this.agglomeration = {} as Agglomeration;
    this.location = {} as Location;
    this.image = {} as Image;
  }
}
