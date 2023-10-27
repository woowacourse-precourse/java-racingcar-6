package racingcar;

public class Application {
    public static void main(String[] args) {
        // 차 목록 입력 받기
        Stadium stadium = new Stadium();
        stadium.saveInputCars(stadium.inputCars());

    }
}
