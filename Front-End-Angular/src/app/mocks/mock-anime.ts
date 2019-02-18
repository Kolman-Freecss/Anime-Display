import { Anime } from '../components/anime/anime';
import { Injectable } from '@angular/core';
import { Gender } from './mock-gender';

@Injectable()
export class MockAnime{

    listAnime: Anime[] = [
        new Anime('Boku no Hero', Gender.HORROR, 1), //{name: , gender: 'Horror'}
        new Anime('Bleach', Gender.ACTION, 2, true),//{name: 'Boku no Hero', gender: 'History'}
    ];

    getMocksAnime(): Anime[]{
        return this.listAnime;
    }

    addAnime(anime: Anime): void{
        anime.setId(this.listAnime.length + 1);
        this.listAnime.push(anime);
    }

}