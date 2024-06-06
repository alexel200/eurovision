import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PagesRoutingModule} from "./pages-routing.module";
import {CitiesPageComponent} from './cities-page/cities-page.component';
import {MaterialModule} from "../material/material.module";
import { CitiesPermutablePageComponent } from './cities-permutable-page/cities-permutable-page.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    CitiesPageComponent,
    CitiesPermutablePageComponent,
  ],
    imports: [
        CommonModule,
        MaterialModule,
        PagesRoutingModule,
        ReactiveFormsModule
    ]
})
export class PagesModule { }
