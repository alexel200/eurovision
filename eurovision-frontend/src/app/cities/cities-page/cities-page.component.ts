import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, PageEvent} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {Cities} from "../../../interfaces/cities";
import {Pageable} from "../../../interfaces/pageable";
import {CitiesService} from "../../../services/cities.service";
import {City} from "../../../interfaces/city";
import {environment} from "../../../environments/environment";


@Component({
  selector: 'app-cities-page',
  templateUrl: './cities-page.component.html',
  styleUrls: ['./cities-page.component.css'],

})
export class CitiesPageComponent implements OnInit {

  length = 10;
  pageSize = environment.defaultPaginationSize;
  pageIndex = 0;
  pageSizeOptions = [5, 10, 25, 50, 100];

  hidePageSize = false;
  showPageSizeOptions = true;
  showFirstLastButtons = true;
  disabled = false;

  pageEvent: PageEvent | undefined;

  displayedColumns: string[] = ['id', 'name'];
  dataSource = new MatTableDataSource<City>();

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  public pageable:Pageable = {
    pageNumber: 0,
    pageSize:   0,
    offset:     0,
    unpaged:    false,
    paged:      false,
  }
  public cities:Cities = {
    totalPages:       0,
    totalElements:    0,
    size:             0,
    content:          [],
    number:           0,
    pageable:         this.pageable,
    numberOfElements: 0,
    first:            false,
    last:             false,
    empty:            false,

  };

  constructor(private citiesService: CitiesService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit(): void {
        this.getCities();
    }


  handlePageEvent(e: PageEvent) {
    this.pageEvent = e;
    this.pageIndex = e.pageIndex;
    this.pageSize = e.pageSize;
    console.log(e);
    this.getCities();
  }

  getCities():void{
    this.citiesService.getCities(this.pageSize, this.pageIndex)
      .subscribe( cities => {
        this.cities = cities
        this.dataSource = new MatTableDataSource<City>(this.cities.content);
        this.length = this.cities.totalElements;
      });
  }
}

