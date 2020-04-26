package org.wuy.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(solution(2,100));;
    }

    /**
     * solution() 输入的是鸡蛋数和楼层数，输出的是最优解
     * 第一个鸡蛋扔在X楼两种情况
     *1：碎了   solution(N-1,X-1)+1
     *2：没碎   solution(N,M-X)+1
     * solution(N,M) = MIN(solution(N-1,X-1)+1,solution(N,M-X)+1)
     */
    public Integer solution(Integer N, Integer M) {
        if(N==1){
            return M;
        }else{
            return min(solution(N-1,10-1)+1,solution(N,M-10)+1);
        }
    }

    public Integer min(Integer a,Integer b){
        return a>b?b:a;
    }
}
