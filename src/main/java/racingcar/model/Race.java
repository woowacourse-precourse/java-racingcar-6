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
            System.out.print(cars[i] + "\n");
        }
        System.out.println();
    }

}
