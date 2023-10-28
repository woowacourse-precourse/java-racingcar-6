package racingcar.control;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Cars;
import racingcar.util.CarService;
import racingcar.util.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Control {
    static List<Integer> carPositions;
    static int maxPosition;
    String[] carNames;
    int rounds;

    // 여기 Control 클래스는 private으로 최대한 써보자! -> 어차피 Model, View로 못 나가니까!
    // main 메서드인 playGame() 먼저 만들고 후에 이 클래스 내에서 나누기
    // Cars 입력받고 List에 넣어주는 메서드도 여기서 구현할 것
    // Winner 판별하는 메서드도 여기

    private void startGame() {
        // 차 이름 입력 받기
        String input = InputView.requestCarName();
        carNames = Cars.makeCarList(input);
        Validation.validateNameInput(carNames);
        // 라운드 수 입력 받기
        String roundInput = InputView.requestRoundNumber();
        rounds = Integer.parseInt(roundInput);
        Validation.validateNumber(rounds);
    }

    private void raceProcess() {
        // round당 실행 시작
        System.out.print("실행결과");

        for (int i = 0; i < rounds; i++) {
            System.out.println();
            for (int j = 0; j < carNames.length; j++) {
                // 랜덤으로 숫자 생성하면
                int randomNumber = CarService.generateRandomNumber();
                // 랜덤 넘버가 4이상이면 carPositions 리스트의 해당 위치(j)에 1씩 더해줌
                if (randomNumber >= 4) {
                    carPositions.set(j, carPositions.get(j) + 1);
                }
                OutputView.printRacingStatus(carNames[j], carPositions.get(j));
            }
        }
    }

    private void savingCarPositions(String[] list) {
        carPositions = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            // 일단 다 0을 채워놓기
            carPositions.add(0);
        }
    }

    // 위너 찾기 (Position 저장해놓은 list에서 최대값 찾아서 반환해주는 메서드)
    private void judgingWinner(List<Integer> list) {
        maxPosition = list.stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0);
    }

    public static void printWinner(String[] list) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            // maxPosition인 int를 찾아 이와 같은 게 있으면 winner 리스트에 추가
            if (carPositions.get(i) == maxPosition) {
                winners.add(list[i]);
            }
        }
        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }
}
