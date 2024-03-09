package bowling.week1;

import java.util.Arrays;

public class test_solution3_1 {
	public int solution(int[] d, int budget) {
        int answer = 0;
        int tmpBudget = 0;
        // 최대 변수 -> 오름 차순 정렬부터
        // 1,2,3,4,5 => 6 = 5 + 1
        // 6 = 1 + 2 + 3
        
        Arrays.sort(d);
        for (int i = 0; i<d.length; i++) { 
            // 1 2 3 4 5, budget = 9;
            if (tmpBudget < budget) {
                answer += 1;
                tmpBudget += d[i];
            } 

            if (tmpBudget > budget) {
                answer -= 1;
                tmpBudget -= d[i];
                break;
            } 
        }
        
        return answer;
    }
}
