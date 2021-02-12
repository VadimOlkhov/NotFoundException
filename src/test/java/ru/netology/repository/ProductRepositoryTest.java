package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "Cinderella", 103, "SharlPerro", 300, 2015);
    Book book2 = new Book(2, "Pinocchio", 170, "Tolstoi", 105, 2019);
    Book book3 = new Book(3, "Mermaid", 407, "Anderson", 456, 2017);
    Book book4 = new Book(4, "iPhone 12", 354, "NoAuthor", 234, 2016);

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
    }

    @Test
    void shouldRemoveByIdYes() {
        repository.removeById(3);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book2, book4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNo() {
        assertThrows(NotFoundException.class,()->repository.removeById(5));
    }

}
