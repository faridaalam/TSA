import { ClientMessage } from './../models/client-message.model';
import { HOST_URL } from './../../environments/environment';
import { User } from './../models/user.model';
import { LoginTemplate } from './../models/loginTemplate.model';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import { Shows } from './../models/shows.model';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private showsURL = "http://api.tvmaze.com"

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
shows: Shows = new Shows(0, "", "", "", "", "", 0, "", "", "", "");
showList?: Shows [];
searchShows(term: string): Observable<any| undefined> {
  console.log(this.http.get<any>(`${this.showsURL}/search/shows?q=${term}`));
  return this.http.get<any>(`${this.showsURL}/search/shows?q=${term}`)
  // return this.http.get<any>(`${this.showsURL}/search/shows?q="girls"`)
   }
  //  this.showList?.push(this.shows))
  //  if (this.showlist = null)
  //   return this.showList;
  //  else return null)

  // searchShows(term: string): Observable<any | undefined> {
  //   return this.http.get<any>(`${this.showsURL}/search/shows?q=${term}`)
  //   .pipe (
  //     map(data => {
  //       const data1 = JSON.parse(data);
  //       const showData = data1;
  //       this.shows.id = showData.id;
  //       this.shows.url = showData.url;
  //       this.shows.name = showData.name;
  //       this.shows.type = showData.type;
  //       this.shows.language = showData.language;
  //       this.shows.status = showData.status;
  //       this.shows.runtime = showData.runtime;
  //       this.shows.premiered = showData.premiered;
  //       this.shows.officialSite = showData.officialSite;
  //       this.shows.image = showData.image;
  //       this.shows.summary = showData.officialSite;
  //       console.log(this.shows)
  //       return this.shows
  //     }))
  //    //  this.showList?.push(this.shows))
  //    //  if (this.showlist = null)
  //    //   return this.showList;
  //    //  else return null)
  //    }


private handleError<T>(operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {
    console.error(error); // log it to the console if something goes wrong
    // Let the app keep running by returning an empty result.
    return of(result as T);
  }
}


}
