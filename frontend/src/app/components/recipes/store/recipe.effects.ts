import {Injectable} from '@angular/core';
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {switchMap, withLatestFrom, map} from 'rxjs/operators';
import {HttpClient, HttpRequest} from '@angular/common/http';
import {Store} from '@ngrx/store';

import {Recipe} from '../recipe.model';
import * as RecipeActions from './recipe.actions';
import * as fromRecipe from './recipe.reducer';

@Injectable()
export class RecipeEffects {
  private url = 'https://ng-recipe-book-aaffd-default-rtdb.firebaseio.com/recipes.json';

  recipeFetch = createEffect(() => {
    return this.actions$.pipe(
      ofType(RecipeActions.FETCH_RECIPE))
      .pipe(switchMap((action: RecipeActions.FetchRecipes) => {
          return this.httpClient.get<Recipe[]>(this.url,
            {
              observe: 'body',
              responseType: 'json'
            });
        }), map(
        (recipes) => {
          for (const recipe of recipes) {
            if (!recipe.ingredients) {
              recipe.ingredients = [];
            }
          }
          return {
            type: RecipeActions.SET_RECIPES,
            payload: recipes
          };
        })
      );
  });

  recipeStore = createEffect(() => {
    return this.actions$.pipe(
      ofType(RecipeActions.STORE_RECIPE))
      .pipe(withLatestFrom(this.store.select('recipes')),
        switchMap(([action, state]) => {
          const req = new HttpRequest(
            'PUT', this.url, state.recipes,
            {reportProgress: true});
          return this.httpClient.request(req);
        }));
  }, {dispatch: false});

  constructor(private actions$: Actions,
              private httpClient: HttpClient,
              private store: Store<fromRecipe.FeatureState>) {
  }
}
