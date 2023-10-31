package racingcar;

public class PrintProcess {
    public static void print(Car[] cars) {
        String str = "";
        for (int i = 0; i < cars.length; i++) {
            str += cars[i].name + " : ";
            for (int j = 0; j < cars[i].steps; j++) {
                str += "-";
            }
            str += "\n";
        }
        System.out.println(str);
    }
}
