import {Location} from './location';
import {Image} from './image';

export class Agglomeration {
  id: number;
  name: string;
  observation: string;
  location = new Location();
  image = new Image();
  agglomerationType: string;
}
