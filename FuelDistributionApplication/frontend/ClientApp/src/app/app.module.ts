import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AppRoutingModule } from './app-routing.modules';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { CreateOrderComponent } from './create-order/create-order.component';
import { NavbarComponent } from './navbar/navbar.component';
import { OrderStatusComponent } from './order-status/order-status.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CreateOrderComponent,
    NavbarComponent,
    OrderStatusComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
