import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { DriveModule } from './app/drive.module';
import 'zone.js';

platformBrowserDynamic().bootstrapModule(DriveModule);
