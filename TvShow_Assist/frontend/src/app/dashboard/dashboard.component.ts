import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from './../services/user-service.service';
import { User } from './../models/user.model';

import { LoginComponent } from './../login/login.component';

import { LoginTemplate } from './../models/loginTemplate.model';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit  {
   user? : User;
  
  image = 'assets/Background.jpeg';

  
  constructor(private userService: UserServiceService, 
    private route: ActivatedRoute,
    private router: Router) {  }

  ngOnInit(): void {
    this.userService.currentUser.subscribe(user => this.user = user)

    console.log(this.user)
    
   
  }

}
