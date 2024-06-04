import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {WelcomeComponent} from "./welcome/welcome.component";

const routes: Routes = [
  {
    path: 'cities',
    loadChildren: () => import('./cities/pages.module').then(m => m.PagesModule)
  },
  {
    path: '',
    component: WelcomeComponent
  },
  {
    path: '**',
    component: WelcomeComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
