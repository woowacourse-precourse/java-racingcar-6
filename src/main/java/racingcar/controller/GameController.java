package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.dto.CarInputDto;
import racingcar.dto.CarOutputDto;
import racingcar.repository.CarRepository;
import racingcar.view.InputVeiw;
import racingcar.view.OutputView;
import java.util.List;

/**
 * RoundController를 분리
 * Service 분리
 */
public class GameController {
    private static final InputVeiw inputView = new InputVeiw();
    private static final CarRepository carRepository = CarRepository.getInstance();
    private Car raceCar;
    private Game game;

    public GameController() {
    }

    /**
     * 역할 분리
     * for문 stream으로 수정
     */
    public void startGame() {
        // 차이름, 횟수 입력받기
        List<String> tmp = inputView.inputCarName(); // List<String> -> Map<>
        for (int i = 0; i < tmp.size(); i++) {
            CarInputDto carInputDto = new CarInputDto(tmp.get(i));
            Car car = new Car(i, carInputDto.getName());
            carRepository.saveCar(car);
        }
        game = new Game(inputView.inputRoundNumber());

        // while 라운드 체크 하며, 게임 수행
        do {
            game.increaseCurrentRound();

            // 게임 수행
            startRound();
            System.out.println();

        } while (game.getCurrentRound() < Game.MAX_ROUND);


        // 우승자 출력
        OutputView.printGameWinner(carRepository.findByAll());
    }

    /**
     * 랜덤값 추출하는 역할 따로 분리
     * for문 stream으로 변경
     */
    private void startRound() {
        // 조건 충족시, raceCar 이동
        for (int i = 0; i < carRepository.size(); i++) {
            Car currentRaceCar = carRepository.findById(i);
            if (game.isMeetCondition(Randoms.pickNumberInRange(0, 9))) {
                Car driveRaceCar = currentRaceCar.drive();
                carRepository.saveCar(driveRaceCar);
            }

            OutputView.printStatusOfRaceCar(currentRaceCar);
        }
    }

}