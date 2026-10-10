package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    @Test
    public void shouldAddAndFindAll() {
        MovieManager manager = new MovieManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 1", "Film 2", "Film 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindAllEmpty() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindLastDefaultLimitWithMoreThanFive() {
        MovieManager manager = new MovieManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");

        String[] expected = {"Film 7", "Film 6", "Film 5", "Film 4", "Film 3"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWithFewerThanLimit() {
        MovieManager manager = new MovieManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 3", "Film 2", "Film 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");

        String[] expected = {"Film 5", "Film 4", "Film 3"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastEmpty() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        assertArrayEquals(expected, manager.findLast());
    }
}