import { RouterModule, Routes } from '@angular/router';
import { ClientMessage } from './../models/client-message.model';
import { LoginTemplate } from './../models/loginTemplate.model';
import { User } from './../models/user.model';
import { UserServiceService } from './../services/user-service.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit  {
  ngOnInit(): void {
    this.userService.currentUser.subscribe(user => this.user = user)
  }
  constructor( private userService: UserServiceService, 
    private route: ActivatedRoute,
    private router: Router) { }

  public user: User = new User(0, '', '', '', '', '');

  public loginTemplate : LoginTemplate = new LoginTemplate('', '');

  public clientMessage: ClientMessage = new ClientMessage('');

  public loginFromService(): void {
    this.userService.signIn(this.loginTemplate).subscribe(data => {
      this.user = data;
      if (this.user != null) {
      console.log(this.user.name);
      this.userService.changeUser(this.user);
      this.router.navigate(["/dashboard"]); }
    
    else { this.clientMessage.message = "Email or Password is incorrect" }}, 
      error => this.clientMessage.message = "Internal Server Error");

      
      
  }




}
