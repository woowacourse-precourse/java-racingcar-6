package racingcar;

public class Game {

    private String[] cars;
    private int num;

    public Game(String[] cars, int num) {
        this.cars = cars;
        this.num = num;
    }

    // 차량 객체 이름 지정 및 이동 거리 0으로 초기화
    void initCar() {
        Car[] car = new Car[this.num];
        for (int i = 0; i < this.num; i++) {
            car[i] = new Car(this.cars[i], 0);
        }
    }

    void startGame() {
        initCar();
    }
}
