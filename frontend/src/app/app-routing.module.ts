import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';

import {ShoppingListComponent} from './components/shopping-list/shopping-list.component';
import {HomeComponent} from './components/core/home/home.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'recipes', loadChildren: () => import('./components/recipes/recipes.module').then(m => m.RecipesModule)},
  {path: 'shopping-list', component: ShoppingListComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes, {preloadingStrategy: PreloadAllModules})
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
