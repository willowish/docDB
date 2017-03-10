package controllers;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import model.drive.uploader.DirectoryNotCreatedException;
import model.drive.uploader.FileNotSavedException;
import model.drive.uploader.Uploader;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

public class UploadController extends Controller {

	private final Uploader uploader;

	@Inject
	public UploadController(Uploader uploader) {
		this.uploader = uploader;
	}

	public Result uploadFile() {
//		TODO: files are saved without extension and with weird name
		List<FilePart<File>> files = getFilesFromRequest();
		for (FilePart<File> file : files) {
			File file1 = file.getFile();
//			TODO: add logger and print some proper info about exceptions and progress
			try {
				uploader.saveFileToDrive(file1);
			} catch (FileNotSavedException e) {
				return badRequest(); // TODO: fix type of Result
			} catch (DirectoryNotCreatedException e) {
				return badRequest(); // TODO: fix type of Result
			}
		}
		return ok();
	}

	private List<FilePart<File>> getFilesFromRequest() {
		Http.MultipartFormData<File> body = request().body().asMultipartFormData();
		return body.getFiles();
	}
}
