import {Component} from "@angular/core";
import {FileUploader} from 'ng2-file-upload';
const URL = '/api/v1/file/';

@Component({
    selector: 'uploader',
    templateUrl: 'uploader.template.html',
    styleUrls: ["./uploader.style.scss".toString()]
})

export class UploaderComponent {

    constructor() {
    }

    public uploader:FileUploader = new FileUploader({url: URL,autoUpload: true});
    public hasBaseDropZoneOver:boolean = false;
    public hasAnotherDropZoneOver:boolean = false;

    public fileOverBase(e:any):void {
        this.hasBaseDropZoneOver = e;
    }

    public fileOverAnother(e:any):void {
        this.hasAnotherDropZoneOver = e;
    }
}


