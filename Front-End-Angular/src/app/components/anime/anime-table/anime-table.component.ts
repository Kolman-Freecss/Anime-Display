import { Component, OnInit } from '@angular/core';
import { MockAnime } from '../../../mocks/mock-anime';
import { Anime } from '../anime';

@Component({
  selector: 'app-anime-table',
  templateUrl: './anime-table.component.html',
  styleUrls: ['./anime-table.component.css']
})
export class AnimeTableComponent implements OnInit {

  listAnime : Anime[];

  constructor(
    private mockAnime : MockAnime
  ) { }

  ngOnInit() {

    this.listAnime = this.mockAnime.getMocksAnime();

  }

}
