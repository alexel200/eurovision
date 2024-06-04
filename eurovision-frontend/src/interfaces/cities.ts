import {City} from "./city";
import {Sort} from "./sort.interface";
import {Pageable} from "./pageable";

export interface Cities {
  totalPages:       number;
  totalElements:    number;
  size:             number;
  content:          City[];
  number:           number;
  sort?:             Sort;
  pageable:         Pageable;
  numberOfElements: number;
  first:            boolean;
  last:             boolean;
  empty:            boolean;
}
