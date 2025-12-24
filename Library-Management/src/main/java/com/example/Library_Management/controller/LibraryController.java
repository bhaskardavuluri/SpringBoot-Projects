package com.example.Library_Management.controller;

import com.example.Library_Management.dto.LibraryDto;
import com.example.Library_Management.entity.Library;
import com.example.Library_Management.service.Impl.LibraryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Library")
public class LibraryController {
    @Autowired
    private LibraryImpl service;
    @PostMapping("/saveLibrary")
    public ResponseEntity<LibraryDto>saveLibrary(@RequestBody LibraryDto libraryDto){
        LibraryDto L=service.saveLibrary(libraryDto);
        return new ResponseEntity<>(L, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Library>findLibrary(@PathVariable Long id){
Library L=service.getLibrary(id);
return new ResponseEntity<>(L,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LibraryDto>updateLibrary(@PathVariable Long id,@RequestBody LibraryDto libraryDto){
        LibraryDto L1=service.updateLibrary(id,libraryDto);
        return new ResponseEntity<>(L1,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
service.deleteBook(id);
return ResponseEntity.ok("Book deleted Successfully");
    }
}
