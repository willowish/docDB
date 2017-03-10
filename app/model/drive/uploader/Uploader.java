package model.drive.uploader;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.Configuration;

@Singleton
public class Uploader {

	private final String UPLOAD_DIRECTORY_CONF_FIELD = "uploader.upload_dir";

	private final Configuration conf;

	@Inject
	public Uploader(Configuration conf) {
		this.conf = conf;
	}

	public synchronized void saveFileToDrive(File fileFromReq) {
		createDirIfNotExists();
		if (!fileSuccessfullySaved(fileFromReq)) {
			throw new FileNotSavedException();
		}
	}

	private boolean fileSuccessfullySaved(File fileFromReq) {
		return fileFromReq.renameTo(new File(conf.getString(UPLOAD_DIRECTORY_CONF_FIELD) + fileFromReq.getName()));
	}

	private void createDirIfNotExists() {
		File dir = new File(conf.getString(UPLOAD_DIRECTORY_CONF_FIELD));
		if (!dir.exists()) {
			if (!dir.mkdir()) {
				throw new DirectoryNotCreatedException();
			}
		}
	}


}
