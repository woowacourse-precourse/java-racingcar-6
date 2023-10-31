# ✅ 기능 목록

- 입력
  - [X] 자동차 이름 입력받기
    - [X] 이름으로 공백을 입력하면 예외 발생
      - [X] 각 이름 앞 뒤로 공백 제거
      - [X] 이름이 중복되면 예외 발생
      - [X] 이름이 5글자 초과시 예외 발생
    - [X] 게임 횟수 입력받기
      - [X] 문자이면 예외 발생
      - [X] 숫자인데 0 또는 음수이면 예외 발생
- 출력
  - [X] 실행 결과 출력문 출력
  - [X] 각 게임 횟수별 출력
  - [X] 최종 우승자 출력
- [X] 0 - 9 사이의 값 추출
- [X] 추출된 값이 4 이상인지 확인(전진 가능한지)
- [X] 자동차 전진
- [X] 우승자 선별
  - 가장 이동 횟수가 많은 자동차가 우승
  - 이때 해당 횟수 이동이 여러 자동차에게 있을 수 있음

# ✅ 설계

- domain
  - Cars
  - Car
  - Name
  - Position
  - Winners
  - PlayCount
- controller
  - RaceController
- util
  - RandomNumberGenerator
- dto
  - CarDto
- view
  - InputView
  - OutputView

# ✅ 회고
- https://velog.io/@dlthgml0108/%EC%9A%B0%ED%85%8C%EC%BD%94-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-2%EC%A3%BC%EC%B0%A8-%ED%9A%8C%EA%B3%A0
