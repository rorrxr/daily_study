package bowling.week2;
import java.util.*;

// 확장 for문 방식
public class test_solution1_1 {
	class Solution {
	    public boolean solution(int x) {      
	        String[] strX = String.valueOf(x).split("");
	        
	        int sum = 0;
	        for (String s : strX) {
	            sum += Integer.parseInt(s);
	        }
	        
	        if (x%sum == 0) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	}
}
