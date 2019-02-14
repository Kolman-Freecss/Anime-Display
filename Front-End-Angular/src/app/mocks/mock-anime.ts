import { Anime } from '../components/anime/anime';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })
export class MockAnime{

    listAnime: Anime[] = [
        {id: 0, name: 'Boku no Hero'},
        {id: 1, name: 'Boku no Hero'},
    ];

    getMocksAnime(): Anime[]{
        return this.listAnime;
    }

}