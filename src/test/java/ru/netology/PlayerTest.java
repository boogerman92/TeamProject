package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void testMostPlayedByGenre() {
        GameStore store = new GameStore();
        Player player = new Player("Mary");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Тетрис", "3вРяд");
        Game game3 = store.publishGame("Doom", "Стрелялка");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 10);
        player.play(game2, 5);
        player.play(game3, 20);
        player.play(game1, 5);
        player.play(game2, 8);
        player.play(game3, 12);

        assertEquals(game3, player.mostPlayerByGenre("Стрелялка"));
    }

    @Test
    public void testNullMostPlayedByGenre() {
        GameStore store = new GameStore();
        Player player = new Player("Mary");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Тетрис", "3вРяд");
        Game game3 = store.publishGame("Doom", "Стрелялка");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 10);
        player.play(game2, 5);
        player.play(game3, 20);
        player.play(game1, 5);
        player.play(game2, 8);
        player.play(game3, 12);

        assertEquals(null, player.mostPlayerByGenre("Action"));
    }
    @Test
    public void testShouldGetName() {
        Player player = new Player("Alex");
        String expectedName = "Alex";
        String actualName = player.getName();
        assertEquals(expectedName, actualName);
    }


    @Test
    public void testPlayGameNotInstalled() {
        Player player = new Player("Alex");
        Game game = new Game("Game1", "Genre1", new GameStore());
        player.play(game, 5);
    }
    // другие ваши тесты
}