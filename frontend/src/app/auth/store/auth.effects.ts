import {Injectable} from '@angular/core';
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {Router} from '@angular/router';
import {map, mergeMap, switchMap, tap} from 'rxjs/operators';
import {from} from 'rxjs';
import firebase from '@firebase/app';
import '@firebase/auth';
import * as AuthActions from './auth.actions';

@Injectable()
export class AuthEffects {
  authSignup = createEffect(() => {
    return this.actions$.pipe(
      ofType(AuthActions.TRY_SIGNUP),
      map((action: AuthActions.TrySignup) => {
        return action.payload;
      })
      , switchMap((authData: { username: string, password: string }) => {
        return from(firebase.auth().createUserWithEmailAndPassword(authData.username, authData.password));
      })
      , switchMap(() => {
        return from(firebase.auth().currentUser.getIdToken());
      })
      , mergeMap((token: string) => {
        return [
          {
            type: AuthActions.SIGNUP
          },
          {
            type: AuthActions.SET_TOKEN,
            payload: token
          }
        ];
      })
    );
  });

  authSignin = createEffect(() => {
    return this.actions$.pipe(
      ofType(AuthActions.TRY_SIGNIN),
      map((action: AuthActions.TrySignup) => {
        return action.payload;
      })
      , switchMap((authData: { username: string, password: string }) => {
        return from(firebase.auth().signInWithEmailAndPassword(authData.username, authData.password));
      })
      , switchMap(() => {
        return from(firebase.auth().currentUser.getIdToken());
      })
      , mergeMap((token: string) => {
        this.router.navigate(['/']);
        return [
          {
            type: AuthActions.SIGNIN
          },
          {
            type: AuthActions.SET_TOKEN,
            payload: token
          }
        ];
      })
    );
  });

  authLogout = createEffect(() => {
    return this.actions$.pipe(
      ofType(AuthActions.LOGOUT),
      tap(() => {
        this.router.navigate(['/']);
      })
    );
  }, {dispatch: false});

  constructor(private actions$: Actions, private router: Router) {
  }
}
