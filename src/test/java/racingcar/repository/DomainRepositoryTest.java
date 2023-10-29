package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.TryCount;

@DisplayName("도메인 저장소 객체에")
class DomainRepositoryTest {

    private final DomainRepository<TryCount> tryCountRepository = new DomainRepository<>();

    @Test
    @DisplayName("저장 후 조회 요청시 null이 아닌 값을 반환하는가")
    void saveAndFind() {
        // given
        // when
        tryCountRepository.save(new TryCount(1));
        final TryCount tryCount = tryCountRepository.find();

        assertThat(tryCount).isNotNull();
    }
}
