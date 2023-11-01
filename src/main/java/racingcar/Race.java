package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

class Race {
    private final Car[] cars;
    private String[] coWinners; // 공동 우승자를 저장할 배열
    private int coWinnersCount = 0; // 공동 우승자 수를 세는 변수

    public Race(String[] carNames) {
        cars = initializeCars(carNames);
        coWinners = new String[carNames.length];
    }

    private Car[] initializeCars(String[] carNames) {
        Car[] initializedCars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            initializedCars[i] = new Car(carNames[i]);
        }
        return initializedCars;
    }

    public void start(int numberOfAttempts) { //입력된 횟수만큼 자동차 움직이고 결과 출력
        for (int i = 0; i < numberOfAttempts; i++) {
            moveCars(); //자동차를 랜덤값으로 움직이는 메소드
            printCars(); // 라운드별 현재 자동차 위치 출력하는 메소드
        }
    }

    private void moveCars() {
        for (Car car : cars) { //0~9중 랜덤값 선택해서 4이상일 경우에만 움직임
            int randomNumber = Randoms.pickNumberInRange(0, 9); // 0부터 9까지의 랜덤 숫자
            if (randomNumber >= 4) {
                car.move(); // 자동차를 한칸(-) 이동시키는 메소드
            }
        }
    }

    private void printCars() {
        for (Car car : cars) { //모든차이 이름과 현재위치 출력
            System.out.println(car.getName().trim() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println("\n");  //한 라운드 진행 후 빈줄 1칸 출력
    }

    //경주결과 출력
    public void printRaceResult() {
        int maxPosition = getMaxPosition(); //가장멀리간 자동차위치
        // 모든 자동차에 대해 최종 위치가 최대 위치와 같으면 공동 우승자로 등록
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                coWinners[coWinnersCount] = car.getName();
                coWinnersCount++;
            }
        }

        // 최종 우승자 출력 시 공동 우승자 처리
        if (coWinnersCount > 1) { // 공동 우승자가 2명 이상일 때
            String delimiter = ", ";
            System.out.print("최종 우승자 : ");

            for (int idx = 0; idx < coWinnersCount; idx++) {
                if (idx < (coWinnersCount - 1)) {
                    System.out.print(coWinners[idx] + delimiter);
                } else {
                    System.out.print(coWinners[idx]);
                }
            }

        } else {
            System.out.print("최종 우승자 : " + coWinners[0]);
        }
    }


    private int getMaxPosition() { //가장멀리간 자동차위치 찾아서 반환
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
