import { ClientMessage } from './../models/client-message.model';
import { User } from './../models/user.model';
import { UserServiceService } from './../services/user-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
 image = 'assets/Background.jpeg';
  constructor(private userService: UserServiceService, 
    private route: ActivatedRoute,
    private router: Router) {  }

    public user: User = new User(0, '','','','','');

    public clientMessage: ClientMessage = new ClientMessage('');
  ngOnInit(): void {
    this.userService.currentUser.subscribe(user => this.user = user)

    console.log(this.user)
  }
  public updateUserFromService(): void {
    this.userService.updateUserService(this.user).subscribe(data => this.clientMessage = data, 
      error => this.clientMessage.message = "INVALID FIELD");
  }
}
