# 웹 기능 - 홈 화면 추가

홈 컨트롤러 추가

```
@Controller
public class HomeController{
	@GetMapping("/")
	public String home(){
		return "home";
	}
}
```

회원 관리용 홈
```
<!DOCTYPE HTML>
<html xmlns:th="<http://www.thymeleaf.org>">
<body>
	<div class = "container">
		<p>회원 기능</p>
		<p>
			<a href="/members/new">회원가입</a>
			<a href="/members">회원 목록</a>
		</p>
	</div>
</body>
</HTML>
```

이 상태에서 localhost:8080을 실행하면 다음과 같은 화면이 실행된다.

![image](https://github.com/rorrxr/daily_study/assets/17608032/2cfd8e3e-fcab-41c9-9167-4ea188f554b0)


회원 가입을 누르면 localhost:8080/members/new 로 이동한다.

회원 목록을 누르면 localhost:8080/members/ 로 이동한다.

이런 식으로 단순한 메인 홈페이지를 만들었다.

# 웹 기능 - 등록(회원 등록)
```
@GetMapping("/members/new")
public String createForm(){
	return "members/createMemberForm";
}
```

컨트롤러에 위와 같은 코드를 작성한다.

이 코드를 작성하면 localhost:8080/members/new를 접속 시members/createMemberForm 파일을 불러와 렌더링하여 페이지에 createMemberForm.html을 출력해줍니다.

우선, createMemberForm.html에서 form 태그를 사용해 이름을 등록하는 html을 작성하자.
```
<!DOCTYPE HTML>
<html xmlns:th="<http://www.thymeleaf.org>">
<body>
	<div class="container">
	 <form action="/members/new" method="post">
		 <div class="form-group">
		 <label for="name">이름</label>
		 <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
		 </div>
		 <button type="submit">등록</button>
	 </form>
	</div> <!-- /container -->
</body>
</html>
```

작성을 완료하고 실행하면 다음과 같은 화면이 렌더링이 되어 출력된다.

![image](https://github.com/rorrxr/daily_study/assets/17608032/a4fc6756-d9f4-411f-bc39-542f17f26aad)


회원 이름을 등록하는 html 껍데기는 완료가 되었다.

어떤 방식으로 입력한 값을 등록해주는 것일까?

우선, 텍스트 박스에 spring이라고 입력한다고 가정하자.

name이라는 이름의 키와 value는 spring이라는 것이 서버로 넘어간다.

현재 우리가 작성한 코드에는 등록하면 아무것도 없기 때문에 전달이 되지 않고 오류가 발생한다.

회원 등록을 컨트롤 하는 것을 만들어보고자 한다.
```
public class MemberForm{
	private String name;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
```

name이라는 String 문자형 변수를 만들고 getter/setter를 생성해준다.

이렇게 하면 이 name이랑 createMemberForm.html의 input 태그 text 박스의 name이 매칭이 된다.

이제 실제 멤버 컨트롤러에 추가해주자.
```
@PostMapping("/members/new")
public String create(MemberForm form){
	Member member = new Member();
	member.setName(form.getName());
	
	memberService.join(member);
	
	return "redirect:/";
}
```

Member라는 객체를 생성하여 MemberForm의 form을 가져와 member에 저장해준다.

멤버 서비스에 이 멤버를 값을 저장해준다.

※ redirect란? 해당 주소로 돌아가는 것을 말하는데 여기선 /을 사용하여 홈 화면으로 돌아간다.

아직 회원 목록 페이지를 만들지 않아서 결과값을 눈으로 볼 수는 없지만,

오류 없이 정상적으로 홈 화면으로 돌아온다면 결과가 잘 들어간 것이다.

# —회원 등록 코드 정리—

지금까지의 코드 로직을 한번 정리해보자.

먼저, 홈 화면에서 회원가입에 들어갑니다. 그러면 localhost:8080/members/new 로 들어가집니다.

이런 식으로 url을 직접 치면 get 방식이라고 한다.

![image](https://github.com/rorrxr/daily_study/assets/17608032/859e9dd6-a648-4321-a976-f9ee953f9ed3)

http 메서드가 있는 get 방식으로 들어옵니다.

그래서 컨트롤러에서 작성한 createForm이 맵핑이 됩니다.

createForm은 members/createMemberForm으로 이동하는 기능을 합니다.
```
@GetMapping("/members/new")
public String createForm(){
	return "members/createMemberForm";
}
```

이 createForm을 통해 템플릿에서 members의 createMemberForm으로 이동합니다.

view resolver라는 애를 통해서 form 태그가 선택되고 thymeleaf 템플릿 엔진에 렌더링 합니다.
```
<!DOCTYPE HTML>
<html xmlns:th="<http://www.thymeleaf.org>">
<body>
	<div class="container">
	 <form action="/members/new" method="post">
		 <div class="form-group">
		 <label for="name">이름</label>
		 <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
		 </div>
		 <button type="submit">등록</button>
	 </form>
	</div> <!-- /container -->
</body>
</html>
```

여기서 form action이 members/new로 method는 post로 되어있다.

input text 형식 박스가 spring이라고 적은 값을 name에 받고,

등록 버튼을 누르면 form action에서 url로 넘어가는데 이것을 post 방식으로 넘겨준다.

member/new Post 방식으로 넘어오면 멤버 컨트롤러의 create가 PostMapping으로 된 것을 받아온다. URL창에 엔터 치는 것은 GetMapping이다.

PostMapping은 폼 태그로 전달할 때 사용한다. GetMapping은 조회할 때 주로 사용한다.


```
public class MemberForm{
	private String name;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
```



컨트롤러에서 create가 호출되면서 값이 들어오는데 MemberForm의 name에 spring이라고 입력한 값이 들어오게 됩니다. 이 spring이라는 값은 이전 html에서 input type 텍스트에서 입력한 spring을 말합니다.

이 값을 MemberForm의 name으로 받아서 setName을 통해서 값을 저장하고, getName으로 값을 꺼냅니다. 여기서 name이 private이기 때문에 setter, getter를 사용합니다.

# 웹 기능 - 조회(회원 목록)


```
@GetMapping("/members")
public String list(Model model){
  List<Member> members = memberService.findMembers();
  model.addAttribute("members", members);
  
  return "members/memberList"
}
```


멤버 서비스에서 findMembers라고 하면 전체 회원을 조회할 수 있다.

model.addAtrribute로 모델에 members을 담아서 화면 view 템플릿에 넘길 것이다.

그래서 members/memberList로 이동하게 해줄 것이기 때문에 경로에 맞게 memberList를 작성하자.



> members/memberList.html 작성
```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>
  <div class="container">
    <div>
      <table>
        <thead>
          <tr>
            <th>#</th>
            <th>이름</th>
          </tr>
        </thead>
        <tbody>
          <tr th:each="member : ${members}">
            <td th:text="${member.id}"></td>
            <td th:text="${member.name}"></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div> <!-- /container -->
</body>
</html>
```


th:each는 루프를 돌면서 이 로직을 실행하는 타임리프 문법이다.

그래서 첫 번째 td 태그에 id를, 두 번째 td 태그에 name을 출력합니다.

![image](https://github.com/rorrxr/daily_study/assets/17608032/81afbf49-771a-4894-97b5-65d4b441afd9)


실행하게 되면 정상적으로 이름이 조회되는 것을 볼 수 있다.

이제 서버를 내린 뒤 다시 서버를 재시작하고 다시 회원조회를 해보자.

![image](https://github.com/rorrxr/daily_study/assets/17608032/1df3c8c7-f9a3-489a-baaa-9efbe72bbd01)


다시 접속하면 데이터가 다 사라져있다.

그 이유는 이 데이터가 메모리에 있었기 때문이다. 그래서 서버를 내리면 데이터가 전부 사라진다.

그래서 이 데이터들을 날아가지 않게 하기 위해서는 데이터베이스가 필요하다.



다음 시간에는 스프링을 데이터베이스로 엑세스하는 방법에 대해서 배워볼 것이다.
