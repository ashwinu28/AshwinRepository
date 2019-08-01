
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, HostListener } from '@angular/core';
@Component({
  selector: 'app-contactus',
  templateUrl: './contactus.component.html',
  styleUrls: ['./contactus.component.css']
})
export class ContactusComponent  {
  contactForm: FormGroup;
  disabledSubmitButton: boolean = true;
  optionsSelect: Array<any>;

  constructor(private fb: FormBuilder) {

    this.contactForm = fb.group({
      'contactFormName': ['', Validators.required],
      'contactFormEmail': ['', Validators.compose([Validators.required, Validators.email])],
      'contactFormSubjects': ['', Validators.required],
      'contactFormMessage': ['', Validators.required],
      'contactFormCopy': [''],
      });
    }
  
  }






  