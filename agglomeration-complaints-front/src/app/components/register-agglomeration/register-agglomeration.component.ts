import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {AgglomerationService} from '../../services/agglomeration.service';
import {Agglomeration} from '../../models/agglomeration';
import {Image} from '../../models/image';
import {Location} from '../../models/location';
import {Router} from "@angular/router";

@Component({
  selector: 'app-register-agglomeration',
  templateUrl: './register-agglomeration.component.html',
  styleUrls: ['./register-agglomeration.component.css']
})
export class RegisterAgglomerationComponent implements OnInit {
  @ViewChild('fileUpload', {static: false}) fileUpload: ElementRef;
  files = [];

  image = {} as Image;
  agglomeration = {} as Agglomeration;
  agglomerations: Agglomeration[];
  fileToUpload: File = null;
  location = {} as Location;

  constructor(private agglomerationService: AgglomerationService, private router: Router) {
  }

  ngOnInit(): void {
    this.agglomeration = {} as Agglomeration;
    this.location = {} as Location;
    this.image = {} as Image;
  }

  async sendFile(file): Promise<void> {
    const formData = new FormData();
    formData.append('file', file.data);
    file.inProgress = true;
    this.agglomerationService.sendFormData(formData).subscribe((event: any) => {
      if (typeof (event) === 'object') {
        this.image = event.body;
        console.log(this.image);
        this.agglomeration.image = this.image;
        console.log(this.agglomeration);
      }
    });
  }

  sendFiles(): void {
    this.fileUpload.nativeElement.value = '';
    this.sendFile(this.files[0]);
  }

  onClick(): void {
    const fileUpload = this.fileUpload.nativeElement; fileUpload.onchange = () => {
      for (let index = 0; index < fileUpload.files.length; index++)
      {
        const file = fileUpload.files[index];
        this.files.push({ data: file, inProgress: false, progress: 0});
      }
      this.sendFiles();
    };
    fileUpload.click();
  }

  saveAgglomeration(form: NgForm): void {
    this.agglomeration.image = this.image;
    this.agglomeration.location = this.location;
    console.log(this.agglomeration);
    if (this.agglomeration.id !== undefined) {
      this.agglomerationService.updateAgglomeration(this.agglomeration).subscribe(() => {
        this.cleanForm(form);
      });
    } else {
      this.agglomerationService.saveAgglomeration(this.agglomeration).subscribe(() => {
        this.cleanForm(form);
      });
    }
    this.router.navigate(['/agglomerations']);
  }

  cleanForm(form: NgForm): void {
    form.resetForm();
    this.agglomeration = {} as Agglomeration;
    this.location = {} as Location;
    this.image = {} as Image;
    this.router.navigate(['/agglomerations']);
  }
}
