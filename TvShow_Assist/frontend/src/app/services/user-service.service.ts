import { ClientMessage } from './../models/client-message.model';
import { HOST_URL } from './../../environments/environment';
import { User } from './../models/user.model';
import { LoginTemplate } from './../models/loginTemplate.model';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private user = new BehaviorSubject<User>(new User(0, '', '','','',''));
  currentUser = this.user.asObservable();
  changeUser(U: User) {
    this.user.next(U)
  }

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  }

  constructor(private http: HttpClient) { }


public signIn(loginTemplate: LoginTemplate): Observable<User>{
  return this.http.post<User>(`${HOST_URL}login`, loginTemplate)

  .pipe (
    catchError(this.handleError<any>('UN and PW incorrect'))
  )
}

public registerUserService(user: User): Observable<ClientMessage> {
  return this.http.post<ClientMessage>(`${HOST_URL}register`, user, this.httpOptions)

  .pipe (
    catchError(this.handleError<any>('cannot register UN and PW'))
  )
}








private handleError<T>(operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {
    console.error(error); // log it to the console if something goes wrong
    // Let the app keep running by returning an empty result.
    return of(result as T);
  }
}

}
