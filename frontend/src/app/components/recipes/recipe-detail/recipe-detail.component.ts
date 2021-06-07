import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {take} from 'rxjs/operators';
import * as ShoppingListActions from '../../shopping-list/store/shopping-list.actions';
import * as fromRecipe from '../store/recipe.reducer';
import * as RecipeActions from '../store/recipe.actions';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {
  recipeState: Observable<fromRecipe.State>;
  id: number;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private store: Store<fromRecipe.FeatureState>) {
  }

  ngOnInit(): void {
    this.route.params
      .subscribe(
        (params: Params) => {
          this.id = +params.id;
          this.recipeState = this.store.select('recipes');
        }
      );
  }

  onAddToShoppingList(): void {
    this.store.select('recipes')
      .pipe(take(1))
      .subscribe((recipeState: fromRecipe.State) => {
        this.store.dispatch(new ShoppingListActions.AddIngredients(
          recipeState.recipes[this.id].ingredients));
      });
  }

  onEditRecipe(): void {
    this.router.navigate(['edit'], {relativeTo: this.route});
  }

  onDeleteRecipe(): void {
    this.store.dispatch(new RecipeActions.DeleteRecipe(this.id));
    this.router.navigate(['/recipes']);
  }
}
