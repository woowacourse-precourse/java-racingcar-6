package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // 경주할 자동차 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        String[] racingCar = carName.split(",");
        int racingCarCount = (int) Arrays.stream(racingCar).count();
        // 이름을 아예 입력하지 않았을 경우(바로 Enter 눌렀을 때), 쉼표를 잘못 사용한 경우
        for (int n=0; n<racingCarCount; n++) {
            if ((racingCar[n] == "") || (racingCar[n] == " ")) {
                throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요.");
            }
        }
        if (racingCar[0] == "") {
            throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요.");
        }
        // 공백이 포함된 경우
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("공백을 제외하고 입력해주세요.");
        }
        // ,,를 쓴 경우
        if (carName.contains(",,")) {
            throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요.");
        }
        // 이름 하나 당 5자 초과할 때
        for (int m=0; m<racingCarCount; m++) {
            if (racingCar[m].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }
        // 맨 마지막이 쉼표(,)로 끝났을 경우
        if (carName.length() == carName.lastIndexOf(",")+1) {
            throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요.");
        }
        // 값을 10개 이상 넣었을 경우
        if (racingCarCount > 9 ) {
            throw new IllegalArgumentException("자동차 이름은 최대 9개까지 설정 가능합니다.");
        }
        // 이름 중복의 경우
        String[] overLap = Arrays.stream(racingCar).distinct().toArray(String[]::new);
        if (overLap.length != racingCarCount) {
            throw new IllegalArgumentException("자동차 이름이 중복되어 있습니다.");
        }
    }
}