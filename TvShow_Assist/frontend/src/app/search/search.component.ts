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
shows$?:Observable<Shows[]>
  constructor(private userService: UserServiceService) { }

  ngOnInit(): void {
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
