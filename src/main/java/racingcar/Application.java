package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingController = new RacingController();
        racingController.startRace();
    }
}