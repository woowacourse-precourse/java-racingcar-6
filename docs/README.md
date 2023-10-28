#  구현 기능 목록
---
## Car 클래스
### 필드
- 자동차 이름
- 위치

### tryMove
- 무작위 값이 4 이상이면 전진

### getPosition
- 클래스 밖에서 객체의 위치 get하기

### getName
- 클래스 밖에서 객체의 이름 get하기
---
## 메서드

### inputCars
- 자동차 이름을 입력 받는다.
- 리스트 형태로 makeCars에 넘겨준다

### makeCars
- 각 자동차를 Car 객체로 만든다.
- 규칙에 어긋나는 경우에는 만들지 않고 프로그램을 종료시킨다.

### isException
- 글자 길이가 5 초과 -> 예외 처리 후 프로그램 종료

### getAttemptsNum
- 몇 번 시도할 것인지 입력받음

### runningRace
- 경주 진행
- 각 객체(차)의 현재 위치

### printRoundResult
- 현재 각 자동차의 위치를 출력한다

### getWinners
- 누가 우승했는지를 알려준다

### getMaxPosition
- 가장 멀리 간 자동차 찾는 메서드

### printWinners
- 우승한 차들 출력하는 메서드