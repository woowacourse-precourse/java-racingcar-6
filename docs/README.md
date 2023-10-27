# 🏎️️ 자동차 경주 🏎️️

---

## ✏️ 개요

- 랜덤하게 진행되는 자동차 경주 게임입니다
    - 사용자로부터 자동차 개수, 이름, 게임 턴 횟수를 입력받습니다.
    - 주어진 턴 내에서 각 자동차는 60% 확률로 전진, 40% 확률로 정지 합니다.
    - 모든 턴이 끝났을 때 가장 앞에 있는 자동차가 승리합니다.

## 🗓️ 구현 할 기능 목록

- [] Car 클래스
    - fields
        - name: 자동차의 이름
        - position: 자동차의 현재 위치
    - functions
        - [] Car(): 생성자
        - [] forward(): 전진하는 함수

- [] Game 클래스
    - fields
        - cars: 자동차 인스턴스 리스트
        - totalTurn: 총 이동 횟수
        - currentTurn: 현재 이동 횟수
    - functions
        - [] Game(): 생성자
        - [] init(): 게임 초기화 함수
        - [] play(): 게임을 진행하는 함수
        - [] result(): 게임 결과를 출력하는 함수
        - [] isForward(): 전진 여부를 결정하는 함수

- [] Validation 클래스
    - fields
    - functions
        - [] Format(): 입력 형식을 검증하는 함수
        - [] Length(): 길이를 검증하는 함수

- [] Message Enum : 게임에 사용할 문자열을 관리하는 enum