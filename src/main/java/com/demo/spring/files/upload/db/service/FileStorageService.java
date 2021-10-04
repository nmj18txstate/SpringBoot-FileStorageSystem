package com.demo.spring.files.upload.db.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.demo.spring.files.upload.db.model.FileDB;
import com.demo.spring.files.upload.db.repository.FileDBRepository;

@Service
public class FileStorageService {

	@Autowired
	private FileDBRepository fileDBRepository;

	public FileDB store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB fileDb=fileDBRepository.findByName(fileName);
		if(fileDb!=null) {
			fileDb.setData(file.getBytes());
			fileDb.setType(file.getContentType());
			return fileDBRepository.save(fileDb);
		}else {
			FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
			return fileDBRepository.save(FileDB);
		}
	}

	public FileDB getFile(String id) {
		return fileDBRepository.findById(id).get();
	}

	public void deleteFile(String id) {
		fileDBRepository.deleteById(id);;
	}

	public Stream<FileDB> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}
}
