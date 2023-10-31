package racingcar.views;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import racingcar.models.RacingCar;

public class InputView {
    public List<RacingCar> getRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        StringTokenizer st = new StringTokenizer(names, ",");
        List<RacingCar> racingCars = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            racingCars.add(new RacingCar(name));
        }
        return racingCars;
    }

    public int getRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        int roundNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return roundNumber;
    }
}
