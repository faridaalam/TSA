import { ClientMessage } from './../models/client-message.model';
import { User } from './../models/user.model';
import { UserServiceService } from './../services/user-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent  {

  constructor(private userService : UserServiceService) { }

  public user: User = new User(0, '','','','','');

  public clientMessage: ClientMessage = new ClientMessage('');

  public registerUserFromService(): void {
    this.userService.registerUserService(this.user).subscribe(data => this.clientMessage = data, 
      error => this.clientMessage.message = "INVALID FIELD");
  }


  

}
