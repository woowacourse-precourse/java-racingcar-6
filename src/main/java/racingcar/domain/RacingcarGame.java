package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.dto.InitDTO;

public class RacingcarGame {
    private Cars racingCars;
    private int rounds;

    public void start(InitDTO initDTO){
        registerCars(initDTO.getCarNames());
        registerRounds(initDTO.getRounds());
    }
    private void play(){
        for(int i=0;i<rounds;i++){
            racingCars.playRound();
        }
        // 차수 별 실행 결과
    }

    private void end(){
        List<Car> winners = racingCars.getWinners();
        // 우승자 출력
    }
    private int registerRounds(int rounds) {
        this.rounds = rounds;
    }

    private Cars registerCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        this.racingCars = new Cars(cars);
    }


}
