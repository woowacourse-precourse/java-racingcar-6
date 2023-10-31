# 프리코스 2주차 미션 - 자동차 경주

![Static Badge](https://img.shields.io/badge/precourse-week2-<color>)
![Static Badge](https://img.shields.io/badge/version-1.1.0-informational)
![Static Badge](https://img.shields.io/badge/test-passed-lightblue)

> 초간단 자동차 경주 게임을 구현합니다.

## 🚀 기능 목록

- [x] 사용자 입력 처리
    - [x] 경주할 자동차 이름을 쉼표(,)를 기준으로 구분 (각 이름은 5자 이하만 가능)
    - [x] 시도할 횟수
    - [x] 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
- [x] 자동차 경주 게임 실행
    - [x] 각 자동차는 지정된 횟수 만큼 전진 또는 멈춤
    - [x] 전진 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4이상일 경우
    - [x] 게임이 완료되면 최종 우승자 선정
- [x] 실행 결과 출력
    - [x] 각 차수별 실행 결과를 자동차 이름으로 구분하여 출력
    - [x] 최종 우승자 출력 (2명 이상인 경우 쉼표(,)를 이용하여 구분)