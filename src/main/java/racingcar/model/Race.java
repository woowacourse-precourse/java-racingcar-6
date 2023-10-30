package racingcar.model;

// 자동차들 모아서 레이싱시킬 때 각각 처리시킬 로직(기존의 RaceTrack)
public class Race {
    private Car[] cars;

    // 입력값 배열로 변환한 값의 각 요소들 Car 타입 덧씌우기
    public Race(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    // 화면단에 출력하기(이제 이걸 이동회수 입력값만큼 반복)
    public void printRace() {
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i].printMovement() + "\n");
        }
        System.out.println();
    }

    // 우승자 뽑기
    // 일단 여기다 작성하고 RankResult 클래스로 분할할 방법 없나... 흠...
    public int rankFirst() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < cars.length; i++) {
            int rank = cars[i].getCarRank();
            if (rank > max) {
                max = rank;
            }
        }

        return max;
    }

    // 우승자 선정 및 출력
    public void selectWinner() {
        RaceResult.printWinner(cars);
    }
}
