import { Injectable } from '@angular/core';
import { Anime } from '../components/anime/anime';
import { MockAnime } from '../mocks/mock-anime';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class AnimeService {

  constructor(
    private mockAnimes : MockAnime,
    private messageService : MessageService,
  ) { }

  getAnimes() : Observable<Anime[]>{
    this.messageService.add("AnimeService: fetched animes");
    return of(this.mockAnimes.getMocksAnime());
  }

  getAnime(id: number): Observable<Anime> {
    //Note the backticks ( ` ) that define a JavaScript template literal for embedding the id.
    this.messageService.add(`AnimeService: fetched anime id=${id}`);
    return of(this.mockAnimes.getMocksAnime().find(anime => anime.id === id));
  }

}
