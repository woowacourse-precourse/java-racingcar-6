# 구현해야 할 기능 목록
-----
## 플레이어 클래스
- 플레이어 이름
- 플레이어 위치

## 랜덤 번호 선택
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현

```Randoms.pickNumberInRange(0,9);```

## 사용자 입력 처리
- camp.nextstep.edu.missionutils.Console의 readLine()을 활용
- , 으로 구분되는 이름 슬라이싱
## 예외 처리
- 사용자가 잘못된 입력을 했을 경우, IllegalArgumentException을 발생시켜 종료시키기
- 이름 입력, 시도 횟수 입력 등에서 예외사항 발생 가능