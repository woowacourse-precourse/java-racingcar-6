package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Application application = new Application();
        application.Start();

    }

    public void Start() {
        Application application = new Application();
        Print print = new Print();
        Input input = new Input();
        Util util = new Util();

        print.printInitName();

        String inputData = input.input_name();
        String[] split = input.devide_name(inputData);
        Exception exception = new Exception();
        exception.exceptionOfNameLength(split);
        Car[] carList = util.createCar(split);

        print.printInitCount();
        int cnt = input.input_count();

        for (int i = 0; i < cnt; i++) {
            util.moveWithRandom(carList);
        }

        print.printResult(carList);

        List<String> victorylist = util.compare(carList);

        print.printVictoryCar(victorylist);

    }


}
