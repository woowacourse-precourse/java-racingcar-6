package racingcar;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        String[] cars = input.getCars();

        int trys = input.getTrys();

        Validator.validateInput(cars, trys);

        int carQuantity = cars.length;
        int[] positions = new int[carQuantity];

        for (int i = 0; i < trys; i++) {
            Move.moveForward(carQuantity, positions);
            Race.excute(cars, positions);
        }

        Winner.choose(cars, positions);
    }
}
