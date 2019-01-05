import { Component } from '@angular/core';
import {AppService} from "./app.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'JobManager Dashboard';
  factories = [];

  constructor(private appService: AppService, private routing: Router){}

  ngOnInit(){
    this.appService.getAllFactories().subscribe(data => console.log(data))
  }

}
