import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PagesRoutingModule} from "./pages-routing.module";
import {CitiesPageComponent} from './cities-page/cities-page.component';
import {MaterialModule} from "../material/material.module";


@NgModule({
  declarations: [
    CitiesPageComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    PagesRoutingModule
  ]
})
export class PagesModule { }
