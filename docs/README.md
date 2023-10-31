<자동차 경주게임 구현>

1. 입력값
	1. 자동차이름 - 쉼표로 구분한 배열, 5자 이하, V
	2. 전진횟수 - 정수값 입력 V

2. 출력값
	1. 기본 실행시 안내 문 V
	2. 전진 회차별 실행 결과 
	3. 최종 우승자(공동, 단독)

3. 계산값
	1. 전진을 위해서는 0~9 사이의 정수값  4 이상
	2. 우승자 발표, 여럿 이상일 시 ','를 통해 구분

4. 오류처리
	1. 잘못된 값 입력 시 IllegalArgumentException발생 후 종
	
EX.) 코드 구현시 주의사항
	1. indent 들여쓰기 3미만으로 구현 할 것(while, if 중첩)	
	2. 3항연산자 사용하지 않기
	3. 함수크기 최소화
	4. JUnit 5 와 AssertJ이용, 정리 기능 목록 정상 동작 테스트코드 확인(test/java/study 참고)
	5. Random값, 입력값은 UTK제공 package 활

추가..

git add -A

git commit -m "style(Allign) : reorganized written lines"

git push origin Recreate