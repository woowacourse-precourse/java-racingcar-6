# 자동차 경주

## 구현 기능 목록

### Application
* main: 제작한 기능들을 종합하여 자동차 경주를 시작한다.

### Driver
* makeDriverRoster: 입력받은 자동차 이름을 Map 형태로 반환한다.
* validateDriverRoster: 이름의 유효성을 검증한다.

### OpportunityValidator
* validateOpportunity: 시도 횟수의 유효성을 검증한다.

### RaceSimulator
* simulateRace: 사용자가 입력한 회수만큼 경주를 실시한다.
* simulateSingleRace: 자동차 경주의 핵심 로직을 수행한다.

### Judge
* calculateWinners: 경주의 우승자(들)을 반환한다.