package racingcar;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class SimpleRacingCarGameRenderer implements RacingCarGameRenderer {

    @Override
    public String renderCars(List<RacingCar> cars) {
        return cars.stream()
                .map(car -> car.render(this))
                .collect(joining("\n"));
    }

    @Override
    public String renderCar(String name, Position position) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s : ", name));
        for (int i = 0; i < position.getX(); i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    @Override
    public String renderWinners(List<String> winners) {
        return "최종 우승자 : " + String.join(", ", winners);
    }

    @Override
    public String renderFirstStage(String text) {
        return "실행 결과\n"+ text;
    }
}
