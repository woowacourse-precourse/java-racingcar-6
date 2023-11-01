package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;
import racingcar.message.ErrorMessage;
import racingcar.message.Message;
import racingcar.player.Player;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Car> carList;
    private Player player;
    private int moveCnt;

    public Game() {
        this.carList = new ArrayList<>();
        this.player = new Player();
    }

    // 게임 시작 전 설정
    public void setUp() {
        setCarNames();
        setMoveCnt();
        System.out.println();
    }

    // 게임 시작
    public void start() {
        System.out.println(Message.GAME_START);

        while (moveCnt > 0) {
            play();
            moveCnt--;
        }
    }

    private void setMoveCnt() {
        System.out.println(Message.INPUT_MOVE_COUNT);
        String inputMoveCnt = player.inputMoveCnt();

        if (!Validator.validateMoveCnt(inputMoveCnt)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_CNT.getMessage());
        }

        moveCnt = Integer.parseInt(inputMoveCnt);
    }

    private void play() {
        for (Car car : carList) {
            if (isMovable()) {
                car.move();
            }
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }


    private void setCarNames() {
        System.out.println(Message.INPUT_CAR_NAMES);

        String[] carNames = player.inputCarNames();

        if (!Validator.validateCarNames(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAMES.getMessage());
        }

        for (String name : carNames) {
            carList.add(new Car(name));
        }
    }
}
