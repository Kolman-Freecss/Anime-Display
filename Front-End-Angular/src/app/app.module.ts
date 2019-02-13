import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimeComponent } from './components/anime/anime-table/anime.component';
import { UserComponent } from './components/user/user.component';
import { MangaComponent } from './components/manga/manga-table/manga.component';
import { FilmComponent } from './components/film/film-table/film.component';
import { AnimeDetailComponent } from './components/anime/anime-detail/anime-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    AnimeComponent,
    UserComponent,
    MangaComponent,
    FilmComponent,
    AnimeDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
