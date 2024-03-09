package bowling.week1;

public class test_solution2 {
	 public String solution(String s) {
	        
	        String answer = "";
	        String[] str = s.split("");
	        // 0부터 시작이라고 하니까 
	        // t r y = 0 1 2
	        // t, y = 대문자, r = 소문자
	        // h e l l o = 0 1 2 3 4
	        // HeLlO
	        
	        int idx = 0;
	        for(int i=0; i<str.length; i++) {
	            if (str[i].equals(" ")) {
	                // 공백을 만나면 순서를 00으로 초기화
	                idx = 1;
	            }
	            
	            if (idx % 2 == 0) {
	                answer += str[i].toUpperCase();
	            } else {
	                answer += str[i].toLowerCase();
	            }
	            
	            idx++;
	        }
	        
	        return answer;
	    }
}
