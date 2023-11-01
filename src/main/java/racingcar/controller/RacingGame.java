package racingcar.controller;

import racingcar.repository.Car;
import racingcar.service.RacingService;
import racingcar.views.GameInput;
import racingcar.views.GameOutput;

import java.util.List;

enum STAGES {
    START,
    PLAY,
    END
}

class MESSAGES {
    static final String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    static final String PLAY = "시도할 회수는 몇회인가요?\n";
    static final String END = "실행 결과\n";
    static final String END2 = "최종 우승자";
}


public class RacingGame implements Game {
    private STAGES stage;
    private RacingService racingService;
    private GameInput gameInput;
    private GameOutput gameOutput;

    public RacingGame(RacingService racingService, GameInput gameInput, GameOutput gameOutput) {
        this.racingService = racingService;
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;
    }

    @Override
    public void start() {
        stage = STAGES.START;
        gameOutput.print(MESSAGES.START);

        String[] names = gameInput.getNames();
        for (String name : names) {
            racingService.generateCar(name);
        }
        play();
    }


    private void play() {
        stage = STAGES.PLAY;
        gameOutput.print(MESSAGES.PLAY);

        int moveCount = gameInput.moveCount();
        for (int i = 0; i < moveCount; i++) {
            racingService.race();
        }

        end();
    }


    private void end() {
        stage = STAGES.END;
        gameOutput.print(MESSAGES.END);

        printRaceResults();
        printWinners();
    }

    private void printRaceResults(){
        List<List<Car>> results = racingService.results();
        for (List<Car> cars : results) {
            for (Car car : cars) {
                gameOutput.print(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
        }
    }

    private void printWinners(){
        List<String> winnerNames = racingService.winners()
                .stream()
                .map(Car::getName)
                .toList();

        gameOutput.print(MESSAGES.END2 + " : "+ String.join(", ", winnerNames));
    }

    @Override
    public boolean isGameEnd() {
        return stage.equals(STAGES.END);
    }
}
