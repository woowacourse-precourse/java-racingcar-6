package racingcar.Model;

import java.util.List;
import racingcar.Dto.CarDto;

public class MidPrint {
    private static StringBuilder sb = new StringBuilder();

    public static String make(List<CarDto> carDtoList) {
        sb = new StringBuilder();
        for (int i = 0; i < carDtoList.size(); i++) {
            printNameAndDash(carDtoList.get(i));
        }
        return returnSB();
    }

    private static String returnSB() {
        return sb.append("\n").toString();
    }

    private static void printNameAndDash(CarDto carDto) {
        printName(carDto.getCarName());
        printDashWithPosition(carDto.getPosition());
    }

    private static void printName(String name) {
        sb.append(name + " : ");
    }

    private static void printDashWithPosition(int position) {
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        sb.append("\n");
    }
}
