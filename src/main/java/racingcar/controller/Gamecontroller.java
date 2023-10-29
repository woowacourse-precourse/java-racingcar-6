package racingcar.controller;

import racingcar.view.PlayerinputView;

public class Gamecontroller {
    private final PlayerinputView playerinputView = new PlayerinputView();
    public static void start(){
        PlayerinputView.getNames();
        PlayerinputView.getRound();
    }

}
