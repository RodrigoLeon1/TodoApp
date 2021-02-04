package com.rodrigoleon.todos.service;

import com.rodrigoleon.todos.exception.folder.FolderDoesNotExistException;
import com.rodrigoleon.todos.model.Folder;
import com.rodrigoleon.todos.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderService {

    private final FolderRepository folderRepository;

    @Autowired
    public FolderService(final FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }


    public Folder create(Folder newFolder) {
        return folderRepository.save(newFolder);
    }

    public List<Folder> findAll() {
        return folderRepository.findAll();
    }

    public Folder findById(Long id) throws FolderDoesNotExistException {
        Optional<Folder> folder = folderRepository.findById(id);
        if (folder.isEmpty()) throw new FolderDoesNotExistException();
        return folder.get();
    }

    public void deleteById(Long id) throws FolderDoesNotExistException {
        Optional<Folder> folder = folderRepository.findById(id);
        if (folder.isEmpty()) throw new FolderDoesNotExistException();
        folderRepository.deleteById(id);
    }

    public Folder updateById(Long id, Folder updatedFolder) throws FolderDoesNotExistException {
        Optional<Folder> folder = folderRepository.findById(id);
        if (folder.isEmpty()) throw new FolderDoesNotExistException();

        folder.get().setName(updatedFolder.getName());

        return folderRepository.save(folder.get());
    }

}

