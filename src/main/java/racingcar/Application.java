package racingcar;

public class Application {
    public static void main(String[] args) {

        CheckForm checkForm = new CheckForm();
        Sorting sort = new Sorting();
        IO io = new IO(checkForm);

        SettingGame settingGame = new SettingGame(io, checkForm);
        RunningGame runningGame = new RunningGame(io, sort, settingGame);

        settingGame.setGame();
        runningGame.runGame();
        runningGame.createResult();
    }
}
