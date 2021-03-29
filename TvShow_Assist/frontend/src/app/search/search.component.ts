import { User } from './../models/user.model';
import { UserServiceService } from './../services/user-service.service';
import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';
import { Shows } from './../models/shows.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
private searchTerm = new Subject<string>()
shows$?:Observable<any>
image = 'assets/Background.jpeg';
  constructor(private userService: UserServiceService) { }
  public user: User = new User(0, '','','','','');
  ngOnInit(): void {
    this.userService.currentUser.subscribe(user => this.user = user);
    this.shows$ = this.searchTerm
    .pipe (
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term:string)=>this.userService.searchShows(term))
    )
  }

  searchShows(term:string): void {
    this.searchTerm.next(term);
  }

}
