import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoggerService } from '../../services/logger.service';
import { MessageService } from '../../services/message.service';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Anime } from '../../components/anime/anime';


const WS_URL = 'http://localhost:8080/anime-display/api/' // URL to webapi

enum TypeCall{ GET, POST, DELETE, UPDATE}

@Injectable({
  providedIn: 'root'
})
export class ClientWsService {

  constructor(
    private http : HttpClient,
    private messageService : MessageService,
    private loggerService : LoggerService,
  ) { }

  getAnimes(): Observable<Anime[]> {
    const url = WS_URL + "anime/getAnimes";
    return this.http.get<Anime[]>(url)
      .pipe(
        catchError(this.handleError<Anime[]>(TypeCall.GET))
      );
  }

  private handleError<T>(operation: TypeCall, result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.loggerService.error(`${operation} failed: ${error.message}`);
      this.messageService.add(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
