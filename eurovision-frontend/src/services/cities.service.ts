import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Cities} from "../interfaces/cities";
import {environment} from "../environments/environment";

@Injectable({providedIn: 'root'})
export class CitiesService {

  private baseUrl: string = environment.baseUrl;
  constructor(private http: HttpClient) {
  }

  getCities(pageSize: number, pageIndex: number):Observable<Cities>{
    return this.http.get<Cities>(`${this.baseUrl}/cities/queryByPage?page=${pageIndex}&size=${pageSize}`)
  }
}
