export class JobDTO{
  id: number;
  status: string;
  jobName: string;

  constructor(id:number, status:string, jobName:string){
    this.id = id;
    this.status = status;
    this.jobName = jobName;
  }
}
