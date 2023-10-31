package racingcar;

public class Application {
    public static void main(String[] args) {

        CheckForm checkForm = new CheckForm();
        Sorting sort = new Sorting();
        IO io = new IO(checkForm);

        Setting setting = new SettingGame(io, checkForm);
        Running running = new RunningGame(io, sort, setting);

        setting.setGame();
        running.runGame();
        running.createResult();
    }
}