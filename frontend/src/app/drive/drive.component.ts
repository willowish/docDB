import {Component} from "@angular/core";
import {UploaderComponent} from './uploader/uploader.component';

@Component({
    selector: 'drive-comp',
    templateUrl: 'drive.template.html',
    styleUrls: ["./drive.style.scss".toString()]
})

export class DriveComponent {
    constructor() {
    }
    
    hello = () => "Hello!"
}
