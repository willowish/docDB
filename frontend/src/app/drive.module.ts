import {Type, NgModule} from "@angular/core";
import {FormsModule} from '@angular/forms';
import {BrowserModule} from "@angular/platform-browser";
import {DriveComponent} from "./drive/drive.component";
import {UploaderComponent} from './drive/uploader/uploader.component'
import {FileUploadModule} from "ng2-file-upload/file-upload/file-upload.module";
@NgModule({
    imports: [
        BrowserModule, FileUploadModule,FormsModule
    ],
    declarations: [DriveComponent, UploaderComponent],
    bootstrap: [DriveComponent]
})
export class DriveModule extends Type {
    constructor() {
        super();
    }
}
