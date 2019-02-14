import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnimeTableComponent } from './components/anime/anime-table/anime-table.component';
import { AnimeDetailComponent } from './components/anime/anime-detail/anime-detail.component';
import { AnimeFormComponent } from './components/anime/anime-form/anime-form.component';

const routes: Routes = [
  { path: '', redirectTo: '/anime-table', pathMatch: 'full' },
  { path: 'anime-table', component: AnimeTableComponent },
  { path: 'anime-detail/:id', component: AnimeDetailComponent },
  { path: 'anime-form', component: AnimeFormComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
