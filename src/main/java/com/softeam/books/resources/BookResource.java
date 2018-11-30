package com.softeam.books.resources;

import com.softeam.books.dao.BookDAO;
import com.softeam.books.dto.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BookResource {

    private final Logger logger = LoggerFactory.getLogger(BookResource.class);

    private final BookDAO bookDAO;

    @Autowired
    public BookResource(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping(path = "/books")
    Collection<BookDTO> books() {

        logger.info("Book Ressource called !");
        return bookDAO.findAll();
    }
}