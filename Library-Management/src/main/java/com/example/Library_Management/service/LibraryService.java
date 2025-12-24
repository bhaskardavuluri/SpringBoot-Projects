package com.example.Library_Management.service;

import com.example.Library_Management.dto.LibraryDto;
import com.example.Library_Management.entity.Library;

public interface LibraryService {
    LibraryDto saveLibrary(LibraryDto libraryDto);
    Library getLibrary(Long id);
    LibraryDto  updateLibrary(Long id ,LibraryDto libraryDto);
    void deleteBook(Long id);
}
