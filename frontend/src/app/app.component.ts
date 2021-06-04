import {Component, OnInit} from '@angular/core';
import {environment} from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'shoppingApp';
  loadedFeature = 'recipe';

  ngOnInit(): void {
    // check if token exists on localStorage
    const savedToken = localStorage.getItem(environment.tokenKey);
    if (savedToken) {
      // @ts-ignore
      this.ngRedux.dispatch(LoginActions.getUserinfo(savedToken));
    }
  }

  onNavigate(feature: string): void {
    this.loadedFeature = feature;
  }
}
