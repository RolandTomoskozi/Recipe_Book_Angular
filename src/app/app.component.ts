import {Component, OnInit} from '@angular/core';
import firebase from '@firebase/app';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'shoppingApp';
  loadedFeature = 'recipe';

  ngOnInit(): void {
    firebase.initializeApp({
      apiKey: 'AIzaSyB3nd2D4Hj8lMQW3MpMd8TGqiIJMOD6c88',
      authDomain: 'ng-recipe-book-aaffd.firebaseapp.com'
    });
  }

  onNavigate(feature: string): void {
    this.loadedFeature = feature;
  }
}
