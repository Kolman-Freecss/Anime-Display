import { Component, OnInit } from '@angular/core';
import { Anime } from '../anime';
import { AnimeService } from '../../../services/anime.service';
import { LoggerService } from '../../../services/logger.service';


@Component({
  selector: 'app-anime-table',
  templateUrl: './anime-table.component.html',
  styleUrls: ['./anime-table.component.css']
})
export class AnimeTableComponent implements OnInit {

  listAnime : Anime[];
  animeSelected : Anime;

  constructor(
    private animeService : AnimeService,
    private loggerService : LoggerService,
  ) { }

  ngOnInit() {

    this.getAnimes();

  }
  
  /*
  onSelect(anime: Anime): void{
    this.animeSelected = anime;
  } 
  */

  getAnimes() : void {
    this.loggerService.log("Retrieving the information of Animes");
    this.animeService.getAnimes()
    .subscribe(animes => this.listAnime = animes);
  }

}
