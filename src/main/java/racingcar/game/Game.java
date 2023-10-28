package racingcar.game;

public interface Game {
    default void awake() {
    }

    /**
     * executed by {@link GameManager} before each game loop
     *
     * @return : true if start gameLoop()
     */
    default boolean beforeLoop() {
        return true;
    }

    /**
     * @return : true if continue loop
     */
    default boolean gameLoop() {
        return false;
    }

    /**
     * executed by {@link GameManager} after each game loop
     *
     * @return : true if restart
     */
    default boolean afterLoop() {
        return false;
    }

    default void cleanup() {
    }
}
