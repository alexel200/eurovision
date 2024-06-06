import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import * as path from "path";
import {CitiesPageComponent} from "./cities-page/cities-page.component";
import {CitiesPermutablePageComponent} from "./cities-permutable-page/cities-permutable-page.component";

const routes: Routes = [
  {
    path: '',
    component: CitiesPageComponent
  },
  {
    path: 'permutable-cities',
    component: CitiesPermutablePageComponent
  }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes),
  ],
  exports: [
    RouterModule
  ],
})

export class PagesRoutingModule{

}
