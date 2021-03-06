package com.dyq.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyq.file.domain.FileGroupByType;
import com.dyq.file.domain.FileGroupByYear;
import com.dyq.file.domain.FileInfo;
import com.dyq.file.domain.FileMapper;
import com.dyq.file.domain.FileState;
import com.dyq.file.domain.FileType;
@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileMapper dao;

	@Override
	public List<FileInfo> queryAllFile(FileInfo file) {
		return dao.queryAllFile(file);
	}

	@Override
	public FileInfo queryFileById(Integer fileId) {
		return dao.queryFileById(fileId);
	}

	@Override
	public int insertFile(FileInfo file) {
		return dao.insertFile(file);
	}

	@Override
	public List<FileState> queryAllState() {
		return dao.queryAllState();
	}

	@Override
	public List<FileType> queryAllType() {
		return dao.queryAllType();
	}

	@Override
	public int updateFileState(Integer fileId, Integer fileStateId) {
		return dao.updateFileState(fileId, fileStateId);
	}

	@Override
	public List<FileGroupByYear> getGroupByFileYear() {
		return dao.getGroupByFileYear();
	}

	@Override
	public List<FileGroupByType> getGroupByFileType() {
		return dao.getGroupByFileType();
	}

	@Override
	public List<FileGroupByYear> getSuccessGroupByFileYear() {
		return dao.getSuccessGroupByFileYear();
	}

	@Override
	public int queryFileCount(FileInfo file) {
		return dao.fileCount(file);
	}

	@Override
	public int updateFileInfo(FileInfo file) {
		return dao.updateFileInfo(file);
	}

	@Override
	public int deleteFile(Integer fileId) {
		return dao.deleteFile(fileId);
	}


}
