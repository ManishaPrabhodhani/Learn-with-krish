import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { OrderStatusComponent } from './order-status/order-status.component';

const routes: Routes = [
    {path:'home',component:HomeComponent},
    {path:'',component:HomeComponent},
    {path:'createOrder',component:CreateOrderComponent},
    {path:'orderStatus',component:OrderStatusComponent},
    //{path:'orderStatus',component:OrderStatusComponent},
    
    
  ];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }