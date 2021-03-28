import { Router, ActivatedRoute } from '@angular/router';
import { UserServiceService } from './../services/user-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private userService: UserServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }

  public logoutFromService(): void {
    this.router.navigate(["/"]);
  //  this.userService.logout()

  }

}
