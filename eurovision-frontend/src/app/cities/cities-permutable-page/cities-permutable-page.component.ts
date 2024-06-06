import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CitiesService} from "../../../services/cities.service";
import {PermutableResponse} from "../../../interfaces/permutable";

@Component({
  selector: 'app-cities-permutable-page',
  templateUrl: './cities-permutable-page.component.html',
  styleUrls: ['./cities-permutable-page.component.css']
})
export class CitiesPermutablePageComponent implements OnInit {
  answerVisible: boolean = false;
  loadingVisible: boolean = false;
  result: PermutableResponse = {};
  public permutableForm:FormGroup = this.fb.group({
    citiesNameLength: [7, [Validators.required, Validators.min(5), Validators.max(7)]]
  });

  constructor(private fb: FormBuilder, private citiesService: CitiesService) { }

  ngOnInit(): void {
  }

  onSend():void{
    if(this.permutableForm.invalid){
      return;
    }
    this.loadingVisible = true;
    this.citiesService.mostPermutableCities(this.permutableForm.controls['citiesNameLength'].value)
      .subscribe( (result:PermutableResponse):void => {
      this.result = result;
      this.answerVisible = true;
      this.loadingVisible = false;
    });
    this.permutableForm.reset({citiesNameLength: 7});
  }

}
