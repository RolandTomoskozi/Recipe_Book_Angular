import {Injectable} from '@angular/core';
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {Router} from '@angular/router';
import {catchError, map, switchMap, tap} from 'rxjs/operators';
import {from, of} from 'rxjs';
import * as AuthActions from '../actions/auth.actions';
import * as AuthApiActions from '../actions/auth-api.actions';
import {AuthService} from '../services/auth.service';

@Injectable()
export class AuthEffects {

  // TODO: change Firebase to Spring Boot Backend
  // -------------- Authentication with Firebase -----------------
  // authSignup = createEffect(() => {
  //   return this.actions$.pipe(
  //     ofType(AuthActions.TRY_SIGNUP),
  //     map((action: AuthActions.TrySignup) => {
  //       return action.payload;
  //     }),
  //     switchMap((authData: { username: string, password: string }) => {
  //       return from(firebase.auth().createUserWithEmailAndPassword(authData.username, authData.password));
  //     })
  //     , switchMap(() => {
  //       return from(firebase.auth().currentUser.getIdToken());
  //     })
  //     , mergeMap((token: string) => {
  //       return [
  //         {
  //           type: AuthActions.SIGNUP
  //         },
  //         {
  //           type: AuthActions.SET_TOKEN,
  //           payload: token
  //         }
  //       ];
  //     })
  //   );
  // });

  // TODO: Check if works
  // -------------- Authentication with Spring Boot -----------------
  authSignin = createEffect(() => {
    return this.actions$.pipe(
      ofType(AuthActions.TRY_SIGNIN)),
      map((action: AuthActions.TrySignup) => {
        return action.payload;
      }),
      switchMap((authData: { username: string; password: string; }) => {
        return from(
          this.authService.login(authData).pipe(
            map((user) => AuthApiActions.loginSuccess({user})),
            catchError((error) => of(AuthApiActions.loginFailure({error})))
          ));
      });
  });

  authLogout = createEffect(() => {
    return this.actions$.pipe(
      ofType(AuthActions.LOGOUT),
      tap(() => {
        this.router.navigate(['/']);
      })
    );
  }, {dispatch: false});

  constructor(private actions$: Actions, private authService: AuthService, private router: Router) {
  }
}
