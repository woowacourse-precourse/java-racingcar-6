package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import service.GameService;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static view.View.getInputLineOfCarNames;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.play();
    }
}
