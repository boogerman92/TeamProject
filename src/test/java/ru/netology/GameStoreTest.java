package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddsGame() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Warcraft", "Strategy");
        Game game3 = store.publishGame("God of war", "action");

        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
    }

    @Test
    public void shouldNoGame() {


        GameStore store = new GameStore();

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Warcraft", "Strategy");
        Game game3 = store.publishGame("God of war", "action");

        assertFalse(store.containsGame(new Game("Warzone", "Shooter", store)));
    }

    @Test
    void testAddPlayTime() {

        GameStore store = new GameStore();
        Player player1 = new Player("Petya");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        player1.installGame(game1);

        store.addPlayTime("Petya", 2);
        store.addPlayTime("Petya", 4);
        assertEquals(6, store.getSumPlayedTime());
    }

    @Test
    void testMostTimePlayerPlayTime() {

        GameStore store = new GameStore();
        Player player1 = new Player("Petya");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        player1.installGame(game1);
        Player player2 = new Player("Alla");
        player2.installGame(game1);

        store.addPlayTime("Petya", 0);
        //store.addPlayTime("Petya", 4);
        store.addPlayTime("Alla", 1);

        assertEquals("Alla", store.getMostPlayer());
    }
    // другие ваши тесты
}