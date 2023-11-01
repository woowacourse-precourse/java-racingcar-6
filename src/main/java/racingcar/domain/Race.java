package racingcar.domain;

public class Race {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DELIMITER = ", ";

    private final Participants participants;
    private final Round round;

    public Race(Participants participants, Round round) {
        this.participants = participants;
        this.round = round;
    }

    public void run() {
        begin();
        result();
    }

    private void begin() {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < round.getRound(); i++) {
            round();
        }
    }

    private void round() {
        for (Car car : participants.getParticipants()) {
            if (RandomNumberGenerator.generate() >= 4) {
                car.forward();
            }
            System.out.println(car.toString());
        }
        System.out.println();
    }

    private void result() {
        System.out.println(WINNER_MESSAGE +
                String.join(DELIMITER, participants.getWinners().stream()
                        .map(Car::getName)
                        .toList())
        );
    }
}
