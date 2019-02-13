import { Component, OnInit } from '@angular/core';
import { MockAnime } from '../../../mocks/mock-anime';
import { Anime } from '../anime';

@Component({
  selector: 'app-anime',
  templateUrl: './anime.component.html',
  styleUrls: ['./anime.component.css']
})
export class AnimeComponent implements OnInit {

  listAnime : Anime[];

  constructor(
    private mockAnime : MockAnime
  ) { }

  ngOnInit() {

    this.listAnime = this.mockAnime.getMocksAnime();

  }

}
