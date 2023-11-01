package racingcar.racingmanager;

import racingcar.domain.Race;

public class GameManger {

    public static void handleGame(){
        SettingGame settingGame = new SettingGame();
        Race race = settingGame.settingRaceAndReturn();

        StartGame startGame = new StartGame(race);
        startGame.startGame();
    }
}
