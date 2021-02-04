package com.rodrigoleon.todos.controller;

import com.rodrigoleon.todos.exception.folder.FolderDoesNotExistException;
import com.rodrigoleon.todos.model.Folder;
import com.rodrigoleon.todos.service.FolderService;
import com.rodrigoleon.todos.utils.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/folders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FolderController {

    private final FolderService folderService;

    @Autowired
    public FolderController(final FolderService folderService) {
        this.folderService = folderService;
    }


    @PostMapping("/")
    public ResponseEntity<Folder> create(@RequestBody @Valid final Folder newFolder){
        // Validate name...
        Folder folder = folderService.create(newFolder);
        return ResponseEntity.created(RestUtils.getLocation(folder.getId())).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Folder>> findAll() {
        List<Folder> folders = folderService.findAll();
        return (folders.size() > 0) ? ResponseEntity.ok(folders) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Folder> findById(@PathVariable final Long id) throws FolderDoesNotExistException {
        Folder folder = folderService.findById(id);
        return ResponseEntity.ok(folder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Folder> deleteById(@PathVariable final Long id) throws FolderDoesNotExistException {
        folderService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Folder> updateById(@RequestBody @Valid final Folder updatedFolder,
                                             @PathVariable final Long id) throws FolderDoesNotExistException {
        Folder folder = folderService.updateById(id, updatedFolder);
        return ResponseEntity.ok(folder);
    }

}
