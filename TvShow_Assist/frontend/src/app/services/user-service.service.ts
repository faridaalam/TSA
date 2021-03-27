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

shows: Shows = new Shows(0, "", "", "", "", 0, "", "", "", "");
showList =  Array <Shows>();
searchShows(term: string): Observable<Shows[]> {
  if(!term.trim()) {
    // if no search term exists, we send back an empty array as an observable
    return of([]);
  }
  return this.http.get<any>(`${this.showsURL}/search/shows?q=${term}`).pipe(
    map(data => {
      
    
        let x = data.length;
        
        
        for (let j = 0; j < x; j++){
        
          for (let i of Array.of(data) ){
            
            this.showList[j] = new Shows (0, "", "", "", "", 0, "", "", "", "");
            this.showList[j].id = i[j].show.id
            this.showList[j].url = i[j].show.url
            this.showList[j].name = i[j].show.name
            this.showList[j].language = i[j].show.language
            this.showList[j].status = i[j].show.status;
            this.showList[j].runtime = i[j].show.runtime;
            this.showList[j].premiered = i[j].show.premiered;
            this.showList[j].officialSite = i[j].show.officialSite;
            if ( (i[j].show.image == null) ||  (i[j].show.image.medium == null) ){
              this.showList[j].image = "../../assets/image-not-found.jpg";
            } else {
            this.showList[j].image = i[j].show.image.medium;}
            this.showList[j].summary = i[j].show.summary;
            if (this.showList[j].summary != null ){
            this.showList[j].summary = this.showList[j].summary.replace( /(<([^>]+)>)/ig, '');
            this.showList[j].summary = this.showList[j].summary.slice(0,100);}
            
        
       

        
      }
    }
       
      
        
        return this.showList;
        
    })
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
