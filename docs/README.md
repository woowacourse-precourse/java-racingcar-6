# 기능 목록

## 🚀 2주차 - 자동차 경주

- 경주할 자동차 이름 입력 받기 - InputView#inputCarList
  - 잘못된 입력을 받은 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료 - Validator#validateInputCarList


- 시도할 횟수 입력 받기 - InputView#inputRoundNum
  - 잘못된 입력을 받은 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료 - Validator#validateInputRoundNum


- 각 자동차의 전진 여부 확인하기 - gameManager#checkMoveOrStop
  - 0에서 9 사이 무작위 값 구하기
  - 4 이상인 경우 전진
  - 4 미만인 경우 멈춤


- 각 회가 끝난 후 결과 출력 - OutputView#printRoundResult


- 시도 횟수가 끝났는지 확인 - gameManager#checkGameFinished
  - 끝나지 않았으면 계속 진행
  - 끝났으면
    - 우승 여부 판단 - gameManager#checkWinner
    - 최종 우승자 출력 - OutputView#printWinner
