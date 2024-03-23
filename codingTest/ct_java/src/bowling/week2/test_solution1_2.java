package bowling.week2;
import java.util.*;

// stream 방식
public class test_solution1_2 {
	class Solution {
	    public boolean solution(int x) {      
	        String[] strX = String.valueOf(x).split("");
	        
	        int sum = Arrays.stream(strX)
	            .mapToInt(Integer::parseInt).sum();
	        
	        if (x%sum == 0) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	}
}
