import {Injectable} from '@angular/core';
import {HttpClient, HttpRequest} from '@angular/common/http';
import {RecipeService} from '../recipes/recipe.service';
import {Recipe} from '../recipes/recipe.model';
import 'rxjs/Rx';

@Injectable()
export class DataStorageService {

  constructor(private httpClient: HttpClient,
              private recipeService: RecipeService) {
  }

  private url = 'https://ng-recipe-book-aaffd-default-rtdb.firebaseio.com/recipes.json';

  storeRecipes() {
    const req = new HttpRequest(
      'PUT', this.url, this.recipeService.getRecipes(),
      {reportProgress: true});
    return this.httpClient.request(req);
  }

  getRecipes() {
    this.httpClient.get<Recipe[]>(this.url,
      {
        observe: 'body',
        responseType: 'json'
      })
      .map(
        (recipes) => {
          for (const recipe of recipes) {
            if (!recipe.ingredients) {
              recipe.ingredients = [];
            }
          }
          return recipes;
        }
      )
      .subscribe(
        (recipes: Recipe[]) => {
          this.recipeService.setRecipes(recipes);
        }
      );
  }
}
