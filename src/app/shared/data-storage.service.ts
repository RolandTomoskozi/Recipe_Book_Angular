import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RecipeService} from '../recipes/recipe.service';
import {AuthService} from '../auth/auth.service';
import {Recipe} from '../recipes/recipe.model';


@Injectable()
export class DataStorageService {

  constructor(private http: HttpClient,
              private recipeService: RecipeService,
              private authService: AuthService) {
  }

  private url = 'https://ng-recipe-book-aaffd-default-rtdb.firebaseio.com/recipes.json';

  storeRecipes() {
    const token = this.authService.getToken();
    return this.http.put(this.url + '?auth=' + token, this.recipeService.getRecipes());
  }

  // FIXME: Deprecated since Angular 6. - Eventuelle Lösung: https://angular.io/guide/http
  // getRecipes() {
  //   const token = this.authService.getToken();
  //
  //   this.http.get(this.url + '?auth=' + token)
  //     .map(
  //       (response: Response) => {
  //         const recipes: Recipe[] = response.json();
  //         for (let recipe of recipes) {
  //           if (!recipe['ingredients']) {
  //             recipe['ingredients'] = [];
  //           }
  //         }
  //         return recipes;
  //       }
  //     )
  //     .subscribe(
  //       (recipes: Recipe[]) => {
  //         this.recipeService.setRecipes(recipes);
  //       }
  //     );
  // }
}
