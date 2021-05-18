import {Component} from '@angular/core';
import {DataStorageService} from '../shared/data-storage.service';
import {HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {
  constructor(private dataStorageService: DataStorageService) {
  }

  onSaveData() {
    this.dataStorageService.storeRecipes()
      .subscribe(
        (response: HttpResponse<any>) => {
          console.log(response);
        }
      );
  }

  // TODO: Im "data-storage.service.ts" muss man die "getRecipes()" ausbessern.
  // onFetchData() {
  //   this.dataStorageService.getRecipes();
  // }
}
