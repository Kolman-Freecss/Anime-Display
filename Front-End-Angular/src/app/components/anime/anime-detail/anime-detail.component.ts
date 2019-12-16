import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { AnimeService }  from '../../../services/anime.service';
import { Anime } from '../../../model/anime';

@Component({
  selector: 'app-anime-detail',
  templateUrl: './anime-detail.component.html',
  styleUrls: ['./anime-detail.component.css']
})
export class AnimeDetailComponent implements OnInit {

  @Input() anime : Anime;

  constructor(
    private route: ActivatedRoute,
    private animeService: AnimeService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getAnime();
  }

  getAnime(): void {
    //The JavaScript (+) operator converts the string to a number, which is what a anime id should be.
    const id = +this.route.snapshot.paramMap.get('id');
    this.animeService.getAnime(id)
      .subscribe(anime => this.anime = anime);
  }

  goBack(): void {
    this.location.back();
  }

}
