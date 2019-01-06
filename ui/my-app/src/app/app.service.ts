import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AppService {

  constructor(private http: HttpClient) { }

  public getAllFactories(){
      return this.http.get('../dashboard/getAllFactories');
  }

  public getAllJobs(){
    return this.http.get('../dashboard/getAllJobs');
  }

}
