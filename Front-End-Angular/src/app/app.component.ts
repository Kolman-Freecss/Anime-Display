import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  imageBackgroundParam="assets/footer_image.png";

  footerStyles = {
    'background-image': 'url(' + this.imageBackgroundParam + ')',
  };

}
