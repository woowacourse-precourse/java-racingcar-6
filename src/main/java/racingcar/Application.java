package racingcar;

public class Application {
    public static void main(String[] args) {
        AppConfiguration appConfiguration = new AppConfiguration();
        GameManager gameManager = appConfiguration.gameManager();

        gameManager.play();
    }
}
