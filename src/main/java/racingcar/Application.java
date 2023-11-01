package racingcar;

import org.w3c.dom.stylesheets.LinkStyle;
import racingcar.domain.Util;
import racingcar.domain.Validation;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.domain.Racing.*;
import static racingcar.domain.Util.*;
import static racingcar.domain.Validation.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        int maxDistance;
        String[] carNames;
        List<Car> Cars;
        String turnCnt;
        List<String> winners;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = getCarNames();
        if (!isNameValid(carNames)) {
            throw new IllegalArgumentException();
        }

        Cars = makeCars(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        turnCnt = readLine();
        if (!isCntValid(turnCnt)) {
            throw new IllegalArgumentException();
        }
        System.out.println();

        doRacing(turnCnt, Cars);
        maxDistance = getMaxDistance(Cars);
        winners = findWinner(maxDistance, Cars);
        printWinner(winners);

    }
}

