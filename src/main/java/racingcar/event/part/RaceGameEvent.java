package racingcar.event.part;

import racingcar.data.RacingCarRepository;
import racingcar.dto.RaceGameResult;
import racingcar.dto.RaceGameResult.TrackPerResult;
import racingcar.event.core.EventListener.ParameterAndReturnEvent;
import racingcar.strategy.RacingCarMoveStrategy;

public record RaceGameEvent(
        RacingCarRepository racingCarRepository
) implements ParameterAndReturnEvent<RacingCarMoveStrategy, RaceGameResult> {

    // 트랙이 5인 경우를 예시로 들면
    // 5 -> 유효
    // 4 -> 유효
    // 3 -> 유효
    // 2 -> 유효
    // 1 -> 유효
    // 0 -> 불가능

    @Override
    public RaceGameResult execute(RacingCarMoveStrategy racingCarMoveStrategy) {
        final var extractTrack = racingCarRepository.findExtractTrack();

        if (extractTrack.isCompleted()) {
            return RaceGameResult.createAlreadyCompletedResult();
        }

        final var participants = racingCarRepository.findParticipants();
        final var movedParticipants = participants.moveAll(racingCarMoveStrategy);

        racingCarRepository.save(movedParticipants);
        racingCarRepository.save(extractTrack.consumerCount());

        return RaceGameResult.processGameResult(movedParticipants.convert(TrackPerResult::from));
    }
}
