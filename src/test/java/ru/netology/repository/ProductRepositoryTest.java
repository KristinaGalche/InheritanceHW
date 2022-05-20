package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Product book1 = new Book(1, "The Forest", 100, "Nekrasov");
    Product book2 = new Book(2, "The Sea", 150, "Ivanov");
    Product phone1 = new Smartphone(3, "Samsung", 5000, "Korea");
    Product phone2 = new Smartphone(4, "Honor", 2000, "China");

    @Test
    void addAndGetProducts() {
        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(phone1);
        repository.add(phone2);

        Product[] actual = repository.getProducts();
        Product[] expected = {book1, book2, phone1, phone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void addAndGetProductsIfEmpty() {
        ProductRepository repository = new ProductRepository();

        Product[] actual = repository.getProducts();
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(phone1);
        repository.add(phone2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, phone1, phone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllIfOneProduct() {
        ProductRepository repository = new ProductRepository();

        repository.add(book2);

        Product[] actual = repository.findAll();
        Product[] expected = {book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(phone1);
        repository.add(phone2);

        Product[] actual = repository.removeById(3);
        Product[] expected = {book1, book2, phone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdIfOneProduct() {
        ProductRepository repository = new ProductRepository();

        repository.add(book1);

        Product[] actual = repository.removeById(1);
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

}