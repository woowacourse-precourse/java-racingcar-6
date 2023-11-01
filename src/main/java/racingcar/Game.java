package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    private final User user;
    private final List<Car> cars;

    private int trialCounts;

    public Game() {
        user = new User();
        cars = new ArrayList<>();
        trialCounts = 0;
    }

    public void play() {
        setRacingCarList();
        setAttemptCounts();
        System.out.println();
        System.out.println(GAME_RESULT_MESSAGE);
        for (int i = 0; i < trialCounts; i++) {
            run();
        }
        printWinners();
    }
