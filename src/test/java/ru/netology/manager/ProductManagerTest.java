package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Product book1 = new Book(1, "The Forest", 100, "Nekrasov");
    Product book2 = new Book(2, "The Sea", 150, "Ivanov");
    Product phone1 = new Smartphone(3, "Samsung", 5000, "Korea");
    Product phone2 = new Smartphone(4, "Honor", 2000, "China");


    @Test
    public void shouldAddAndFindAll() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.findAll();
        Product[] expected = { book1, book2, phone1, phone2 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndSearchByProducer() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("sung");
        Product[] expected = { phone1 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndSearchByTitle() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("Sea");
        Product[] expected = { book2 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndSearchBySpace() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy(" ");
        Product[] expected = { book1, book2 };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndSearchByDot() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy(".");
        Product[] expected = { };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void matches() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Boolean actual = manager.matches(book2, "ea");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.removeById(3);
        Product[] expected = { book1, book2, phone2 };
        assertArrayEquals(expected, actual);

    }

}