package com.example.Library_Management.service.Impl;

import com.example.Library_Management.dto.LibraryDto;
import com.example.Library_Management.entity.Library;
import com.example.Library_Management.repository.LibraryRepository;
import com.example.Library_Management.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class LibraryImpl implements LibraryService {
    @Autowired
    private LibraryRepository repository;

    public LibraryDto saveLibrary(LibraryDto libraryDto) {
        Library L = new Library(
                libraryDto.getId(),
                libraryDto.getName(),
                libraryDto.getAuthor(),
                libraryDto.getPrice()
        );
        Library savedLibrary = repository.save(L);
        LibraryDto saveLibrary = new LibraryDto(
                savedLibrary.getId(),
                savedLibrary.getName(),
                savedLibrary.getAuthor(),
                savedLibrary.getPrice()
        );
        return saveLibrary;
    }

    public Library getLibrary(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id number" + id));
    }

    public LibraryDto updateLibrary(Long id, LibraryDto libraryDto) {
        Library L = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found for the given id: " + id));
        L.setName(libraryDto.getName());
        L.setAuthor(libraryDto.getAuthor());
        L.setPrice(libraryDto.getPrice());
Library updatedLibrary=repository.save(L);
return new LibraryDto(
        updatedLibrary.getId(),
        updatedLibrary.getName(),
        updatedLibrary.getAuthor(),
        updatedLibrary.getPrice()
);
     }

    @Override
    public void deleteBook(Long id) {
        Library l=repository.findById(id)
                .orElseThrow(()->new RuntimeException("Book deleted successfullly"+id));
        repository.delete(l);
    }
}



