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
  factories = null;
  jobs = null;

  constructor(private appService: AppService, private routing: Router){}

  ngOnInit(){
    // Gets array of factories
    this.appService.getAllFactories().subscribe(data => this.factories = data);
    // Gets all current jobs
    this.appService.getAllJobs().subscribe(data => this.jobs = data);
  }

}
