import { Injectable } from '@angular/core';
import { Anime } from '../components/anime/anime';
import { MockAnime } from '../mocks/mock-anime';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { ClientWsService } from '../webservice/clientWS/client-ws.service';

@Injectable({
  providedIn: 'root'
})
export class AnimeService {

  constructor(
    private mockAnimes : MockAnime,
    private messageService : MessageService,
    private clientWsService : ClientWsService,
  ) { }

  getAnimes() : Observable<Anime[]>{
    this.messageService.add("AnimeService: fetched animes");
    return this.clientWsService.getAnimes();//of(this.mockAnimes.getMocksAnime());
  }

  getAnime(id: number): Observable<Anime> {
    //Note the backticks ( ` ) that define a JavaScript template literal for embedding the id.
    this.messageService.add(`AnimeService: fetched anime id=${id}`);
    return of(this.mockAnimes.getMocksAnime().find(anime => anime.id === id));
  }

  addAnime(anime: Anime): Observable<Anime>{
    return this.clientWsService.createAnime(anime);
    //this.mockAnimes.addAnime(anime);
  }

  deleteAnime(id : number): Observable<{}>{
    return this.clientWsService.deleteAnime(id);
  }

}
