package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingApp {

    private int executeCount;
    private List<RacingCar> racingCarList = new ArrayList<>();

    public void run() {
        String input = getPlayerList();
        createRacingCarList(input);
        getExecuteCount();

        play();

    }

    private void play() {
        System.out.println("실행 결과");
        for (int i = 0; i < executeCount; i++) {
            executeOneStep();
        }
    }

    private void executeOneStep() {
        racingCarList.forEach(racingCar -> {
            int number = Randoms.pickNumberInRange(0,9);
            if(number >= 4){
                racingCar.moveOneBlock();
            }
        });
    }


    private void getExecuteCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            this.executeCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        System.out.println("\n");
    }

    private String getPlayerList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private void createRacingCarList(String input) {
        List<String> nameList = getNameListFromInput(input);
        createRacingCarListByNameList(nameList);
    }

    private void createRacingCarListByNameList(List<String> nameList) {
        nameList.forEach(name -> racingCarList.add(new RacingCar(name)));
    }

    private List<String> getNameListFromInput(String input) {
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }


}
