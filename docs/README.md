# woowacourse java-racinqcar-6

## Description
- 자동차 경주 게임

## Environment
- java 17.0.2

## Funtion List
1. 입력
- 경주할 자동차 목록 입력
> inputNames()
- 전진 또는 멈출 수 있는 이동 기회 횟수 입력
> inputCount()

2. 계산 및 출력
- 횟수마다 무작위 값에 따라 각 자동차가 이동 여부에 따라 move count 추가
> moveForwardAll() -> moveForward() 
- 각 자동차마다 이동하면 - 표시 추가하여 출력
> printExecuteResults()
- 총 시도 횟수가 끝났을 경우 최종 우승자 판단 후 출력
> findWinners() -> printWinners()
