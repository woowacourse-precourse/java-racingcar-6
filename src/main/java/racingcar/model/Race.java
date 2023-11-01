package racingcar.model;

import java.util.List;

public class Race {

    private Round roundLeft;
    private Entry entry;

    public static int getMinEntrySize() {
        final int MIN_ENTRY_SIZE = 2;
        return MIN_ENTRY_SIZE;
    }

    /**
     * 명시된 라운드 수와 엔트리를 이용하여 경주(Race) 객체를 생성한다.
     * @param totalRound 진행할 총 라운드 수
     * @param entry 참가자 엔트리
     * @throws IllegalArgumentException 참가자 엔트리의 크기가 Race.getMinEntrySize() 보다 작은 경우
     */
    public Race(Round totalRound, Entry entry) throws IllegalArgumentException {
        if (entry.size() < Race.getMinEntrySize()) {
            throw new IllegalArgumentException("경주를 진행하기 위해서는 최소 크기가 2인 엔트리가 필요합니다.");
        }

        this.roundLeft = totalRound;
        this.entry = entry;
    }

    public boolean isFinished() {
        return roundLeft.equals(new Round(0));
    }

    /**
     * 경주의 한 라운드를 진행한다.
     */
    public void next() {
        if (isFinished()) {
            return;
        }

        entry.driveAll();
        roundLeft.decreaseByOne();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(entry.toString());
        ret.append("\n");

        if (roundLeft.equals(new Round(0))) {
            ret.append("최종 우승자 : ");

            List<String> names = entry
                    .getWinners()
                    .stream()
                    .map(car -> new String(car.getMyName()))
                    .toList();
            ret.append(String.join(", ", names));


        }

        return ret.toString();
    }
}
