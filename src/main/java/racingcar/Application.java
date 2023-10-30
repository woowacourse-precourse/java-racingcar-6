package racingcar;

import racingcar.domain.Game;
import racingcar.domain.Car;
import racingcar.domain.GameMaker;
import racingcar.domain.WinnerDeterminer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 승자를 판단하는 클래스

public class Application {
    public static void main(String[] args) {
        GameMaker maker = new GameMaker();
        Game manager = new Game(maker.cars, maker.totalRounds);
        manager.play();
    }
}
