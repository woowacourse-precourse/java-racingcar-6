# 구현할 기능 목록

## 단순 기능 구현

- [ ] `scanner` 사용해 자동차 값, 시도할 횟수 입력받기
- [ ] `split()`으로 구분자 주고, 5자 이하인지 검사
- [ ] `Randoms.pickNumberInRange(0,9)`에 의해 값 생성 
  - 이 값이 4 이상이면 전진, 아니면 전진하지 않음 
- [ ] 값에 의한 실행 결과를 저장 및 출력 메소드
- [ ] 최종 우승자(중복 가능) 출력 메소드

## 패턴 적용

- [ ] `Controller`와 `Viewer`클래스를 분리
- [ ] `Controller` -> `Model` (기능 코드) 로 분리
- [ ] 수행하는 기능에 따라 MVC, model의 package 분리


## 단위 테스트 코드 구현

- `test/java/study` 참고해 TC 작성