package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import racingcar.model.GONumberGenerator;
import racingcar.model.NumberGenerator;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.List;

class OutputViewTest {
    private static final String ENTER_REGEX = "\n";
    private static final String COLON_REGEX = " : ";
    private static final String DASH_REGEX = "-";
    private static final String COMMA_REGEX = ", ";
    private static final String ROUND_MSG = "실행 결과";
    private static final String WINNER_MSG = "최종 우승자";

    public String printRoundResult(RacingCars racingCars) {
        StringBuilder result = new StringBuilder();
        result.append(ENTER_REGEX)
                .append(ROUND_MSG)
                .append(ENTER_REGEX);
        for (RacingCar car : racingCars.getRacingCars()) {
            result.append(car.getName())
                    .append(COLON_REGEX)
                    .append(DASH_REGEX.repeat(car.getDistance()))
                    .append(ENTER_REGEX);
        }
        return result.toString();
    }

    public String printWinnerResult(List<RacingCar> winners) {
        StringBuilder result = new StringBuilder();
        result.append(ENTER_REGEX)
                .append(WINNER_MSG)
                .append(COLON_REGEX);
        for (RacingCar car : winners){
            result.append(car.getName())
                    .append(COMMA_REGEX);
        }
        result.replace(result.length() - 2, result.length(), "");
        return result.toString();
    }

    @Test
    void winner_출력결과_테스트() {
        //given
        NumberGenerator numberGenerator = new GONumberGenerator();
        List<RacingCar> list = new ArrayList<>();
        RacingCar car1 = RacingCar.from("jun");
        car1.move(numberGenerator);
        car1.move(numberGenerator);
        RacingCar car2 = RacingCar.from("woni");
        car2.move(numberGenerator);
        list.add(car1);
        list.add(car2);
        //when
        String result = printWinnerResult(list);
        //then
        assertThat(result).isEqualTo("\n최종 우승자 : jun, woni");

    }

    @Test
    void round_출력결과_테스트(){
        //given
        NumberGenerator numberGenerator = new GONumberGenerator();
        List<RacingCar> list = new ArrayList<>();
        RacingCar car1 = RacingCar.from("jun");
        car1.move(numberGenerator);
        car1.move(numberGenerator);
        RacingCar car2 = RacingCar.from("woni");
        car2.move(numberGenerator);
        list.add(car1);
        list.add(car2);
        RacingCars racingCars = RacingCars.from(list);
        //when
        String result = printRoundResult(racingCars);
        //then
        assertThat(result).isEqualTo("\n실행 결과\njun : --\nwoni : -\n");
    }

}