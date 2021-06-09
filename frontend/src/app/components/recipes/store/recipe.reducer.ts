import {Recipe} from '../recipe.model';
import * as RecipeActions from './recipe.actions';
import * as fromApp from '../../../store/app.reducers';

export interface FeatureState extends fromApp.AppState {
  recipes: State;
}

export interface State {
  recipes: Recipe[];
}

const initialState: State = {
  recipes: []
};

export function recipeReducer(state = initialState, action: RecipeActions.RecipeActions): State | { recipes: Recipe } {
  switch (action.type) {
    case (RecipeActions.SET_RECIPES):
      return {
        ...state,
        recipes: [...action.payload]
      };
    case  (RecipeActions.ADD_RECIPE):
      return {
        ...state,
        recipes: [...state.recipes, action.payload]
      };
    case  (RecipeActions.UPDATE_RECIPE):
      const recipe = state.recipes[action.payload.index];
      const updatedRecipe = {
        ...recipe,
        ...action.payload.updatedRecipe
      };
      const recipes = [...state.recipes];
      recipes[action.payload.index] = updatedRecipe;
      return {
        ...state,
        recipes: recipe
      };
    case  (RecipeActions.DELETE_RECIPE):
      const deletedRecipes = [...state.recipes];
      deletedRecipes.splice(action.payload, 1);
      return {
        ...state,
        recipes: deletedRecipes
      };
    default:
      return state;
  }
}
