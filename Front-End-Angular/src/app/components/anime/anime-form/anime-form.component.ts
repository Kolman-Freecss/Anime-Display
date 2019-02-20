import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AnimeService } from '../../../services/anime.service'
import { Anime } from '../anime';
import { Gender } from '../../../mocks/mock-gender';

@Component({
  selector: 'app-anime-form',
  templateUrl: './anime-form.component.html',
  styleUrls: ['./anime-form.component.css']
})
export class AnimeFormComponent implements OnInit {

  /*addAnimeForm = new FormGroup({
    gender: new FormControl(''),
    name: new FormControl(''),
  });*/
  genderOptions: String[];
  animeSubmitted : Anime;

  constructor(
    private location: Location,
    private formBuilder: FormBuilder,
    private animeService: AnimeService,
  ) { }

  addAnimeForm = this.formBuilder.group({
    gender: ['', Validators.required],
    name: ['', Validators.required],
    website: ['', Validators.required],
    isFinished: ['', Validators.required]
  });

  ngOnInit() {
    console.log(this.addAnimeForm.status);
    this.loadGenderList();
  }

  goBack(): void {
    this.location.back();
  }

  loadGenderList() : void {
    this.genderOptions = Object.values(Gender);
    console.log(this.genderOptions);
  }

  updateName(): void{
    /*this.gender.valueChanges.
      subscribe(
        value => value === "Action" ? this.name.setValue("Bleach") : this.name.setValue("Horror")
      );*/
      this.addAnimeForm.patchValue({
        name: 'Sergio',
      });
  }

  onSubmit(): void {
    this.animeSubmitted = this.saveAnime();

    this.animeService.addAnime(new Anime(this.animeSubmitted.name, this.animeSubmitted.gender, this.animeSubmitted.website, this.animeSubmitted.isFinished))
    .subscribe(() => this.location.back());
    //this.addAnimeForm.get("gender"), this.addAnimeForm.get("name"), this.addAnimeForm.get("website"), this.addAnimeForm.get("isFinished")
    //this.addAnimeForm.get('name').value, this.addAnimeForm.get('gender').value, "website")
    //this.location.back();
    console.warn(this.addAnimeForm.value);
    console.log(this.addAnimeForm.status);
  }

  saveAnime() : Anime{
    const formModel = this.addAnimeForm.value;

    const saveAnime : Anime = {
      name : formModel.name as String,
      gender : formModel.gender as Gender,
      website : formModel.website as String,
      isFinished : formModel.isFinished as boolean,
    }

    return saveAnime;
  }

}
