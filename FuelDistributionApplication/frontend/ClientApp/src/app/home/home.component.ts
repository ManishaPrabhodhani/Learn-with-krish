import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  load_createOrder(){
    this.router.navigate(['createOrder'])
  }

  load_orderStatus(){
    this.router.navigate(['orderStatus'])
  }


}
