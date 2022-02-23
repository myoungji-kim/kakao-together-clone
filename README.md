[To Do]
- E: Encoding Filter 에러 해결 (url 설정하면 CSS 전부 깨짐)
- update servlet 구현
- sysout 대신 logger 사용하기
- 마이페이지 '나의 글'에서 본인이 작성한 글 목록 확인
- 글 삭제하기 구현
- Footer 추가 (+ 문의하기 기능 => mail api 적용)
- 프로모션 게시판 html
- 프로모션 페이징 

[Success]
(02/22 => 새벽 5시에 잤따 ...)
- 기부금에 따라 div 바 길이 설정 <br>
	=> price, pricestate를 활용해 진행된 %만큼 width 값을 지정  <br>
 <br>
- 글 등록하기
	=> 카테고리 선택 js 메서드 생성 <br>
	=> 하나의 등록하기 페이지에서 모든 카테고리를 설정할 수 있음  <br>
 <br>
- 글 수정하기
	=> 거의 2시간 동안 프로젝트 구조 대공사 .. 
	   처음에 ERD나 DTO 구조 잘 기획하자 ㅠㅠㅠ  <br>
	   cate, topic, subtopic 네이밍이나 필요한 추가 파라미터 넣으면서 난리남.. <br>
	=> 수정하기 들어갈 때 cate와 글 idx를 파라미터로 넘기면서 mode가 update로 되고, <br>
	   해당하는 값들 다 set함 <br>
	=> 카테고리는 변경 불가능하게 함 <br>
 <br>
- 멤버별 글 수정모드 on/off
	=> 로그인 세션 정보 중 멤버 idx 받아와서 게시글의 writer의 idx와 일치할 경우 수정 버튼 visible <br>
 <br>
- now 글 자세히 보기
	=> html, css 구현 완료 <br>
 <br>
- 파일 네이밍 전면 수정
	=> 짧고 간결하게, 이해하기 쉽게 네이밍하자!! <br>

- 마이페이지 카테고리 나누기 
	=> 내 정보, 나의 글, 내 기부 <br>
 <br>
 <br>

(02/21) <br>
- 로그인 세션 오류 해결 
	=> <%page session="False"%> 막 넣지 않기 <br>
 <br>
- 마이페이지 완성
	=> 정보 수정 완성 <br>
 <br>
- 글 자세히 보기 jsp 생성 
	=> 파라미터 값 받아오는 것만 구현 <br>
