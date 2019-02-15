import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { AnimeDetailComponent } from './components/anime/anime-detail/anime-detail.component';
import { AnimeTableComponent } from './components/anime/anime-table/anime-table.component';
import { FilmTableComponent } from './components/film/film-table/film-table.component';
import { FilmDetailComponent } from './components/film/film-detail/film-detail.component';
import { MangaDetailComponent } from './components/manga/manga-detail/manga-detail.component';
import { MangaTableComponent } from './components/manga/manga-table/manga-table.component';
import { UserTableComponent } from './components/user/user-table/user-table.component';
import { UserDetailComponent } from './components/user/user-detail/user-detail.component';
import { MessagesComponent } from './components/messages/messages.component';
import { MockAnime } from './mocks/mock-anime';
import { AnimeFormComponent } from './components/anime/anime-form/anime-form.component';
import { FooterComponent } from './components/design/footer/footer.component';
import { HeaderComponent } from './components/design/header/header.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AnimeDetailComponent,
    AnimeTableComponent,
    FilmTableComponent,
    FilmDetailComponent,
    MangaDetailComponent,
    MangaTableComponent,
    UserTableComponent,
    UserDetailComponent,
    MessagesComponent,
    AnimeFormComponent,
    FooterComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    MockAnime,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
