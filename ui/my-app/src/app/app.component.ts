import { Component } from '@angular/core';
import {AppService} from "./app.service";
import {Router} from "@angular/router";
import {JobDTO} from "./job/job";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Job Manager Dashboard';
  factories = null;
  jobs = null;
  RUNNING = "RUNNING";
  displayedColumns = ['jobName', 'jobStatus'];

  constructor(private appService: AppService, private routing: Router){}

  ngOnInit(){
    // Gets array of factories
    // this.appService.getAllFactories().subscribe(data => this.factories = data);
    // Gets all current jobs
    // this.appService.getAllJobs().subscribe(data => this.jobs = data);

    this.factories = [new JobDTO(1, "SCHEDULED", "TestJob"), new JobDTO(2, "RUNNING", "TestJob")];
    this.jobs = ["TestJob"]
  }

}
