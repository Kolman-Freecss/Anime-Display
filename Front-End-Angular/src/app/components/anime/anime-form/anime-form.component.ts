import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { FormControl } from '@angular/forms';
import { getDebugNode__POST_R3__ } from '@angular/core/src/debug/debug_node';

@Component({
  selector: 'app-anime-form',
  templateUrl: './anime-form.component.html',
  styleUrls: ['./anime-form.component.css']
})
export class AnimeFormComponent implements OnInit {

  gender = new FormControl('');
  name = new FormControl('');

  constructor(
    private location: Location,
  ) { }

  ngOnInit() {
  }

  goBack(): void {
    this.location.back();
  }

  updateName(): void{
    this.gender.valueChanges.
      subscribe(
        value => value === "Action" ? this.name.setValue("Bleach") : this.name.setValue("Horror")
      );
  }

}
