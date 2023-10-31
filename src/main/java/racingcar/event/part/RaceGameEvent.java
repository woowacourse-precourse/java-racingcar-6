package racingcar.event.part;

import racingcar.data.RacingCarRepository;
import racingcar.event.core.EventListener.ParameterAndReturnEvent;
import racingcar.strategy.RacingCarMoveStrategy;
import racingcar.view.part.RaceGameComponent.RaceGameResult;
import racingcar.view.part.RaceGameComponent.RaceGameResult.TrackPerResult;

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

        racingCarRepository.saveParticipants(movedParticipants);
        racingCarRepository.saveExtractTrack(extractTrack.consumerCount());

        return RaceGameResult.processGameResult(movedParticipants.convert(TrackPerResult::from));
    }
}
