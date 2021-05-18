import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RecipeService} from '../recipes/recipe.service';


@Injectable()
export class DataStorageService {

  constructor(private http: HttpClient, private recipeService: RecipeService) {
  }

  private url = 'https://ng-recipe-book-aaffd-default-rtdb.firebaseio.com/recipes.json';

  storeRecipes() {
    return this.http.put(this.url, this.recipeService.getRecipes());
  }

  // FIXME: Deprecated since Angular 6. - Eventuelle Lösung: https://angular.io/guide/http
  // getRecipes() {
  //   this.http.get(this.url)
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
