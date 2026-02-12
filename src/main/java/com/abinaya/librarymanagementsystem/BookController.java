package com.abinaya.librarymanagementsystem;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book Added Successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        books.removeIf(book -> book.getId() == id);
        return "Book Deleted Successfully!";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        for (Book b : books) {
            if (b.getId() == id) {
                b.setName(updatedBook.getName());
                b.setAuthor(updatedBook.getAuthor());
                return "Book Updated Successfully!";
            }
        }
        return "Book Not Found!";
    }
}