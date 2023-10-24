import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CaptureStonesGameComponent} from "./capture-stones-game/capture-stones-game.component";

const routes: Routes = [
  { path: '', component: CaptureStonesGameComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
