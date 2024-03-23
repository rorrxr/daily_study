package zam.week2;

/*
문제 설명
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
*/

public class test_solution2 {
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        /*
	        int max;
	        int min;
	        int num;
	        
	        String[] str = s.split("");
	        for(int i = 0; i < str.length; i++){
	            if(str[i].equals(" ")){
	                num += i;
	            }
	            // 최대값
	            if(str[i] > num){
	                max += str[i];
	            }
	            
	            // 최소값
	            if(str[i] < num){
	                min += str[i];
	            }
	        }
	        */
	        
	        String[] numbers = s.split(" ");
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        
	        for(int i = 0; i < numbers.length; i++){
	            int number = Integer.parseInt(numbers[i]);
	            
	            min = Math.min(min, number);
	            max = Math.max(max, number);
	        }

	        answer = min+ " " +max;
	        
	        return answer;
	    }
	}
}
