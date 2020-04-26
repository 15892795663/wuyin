package org.wuy.demo;

/**
 * @Title:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * @Description: TODO
 * @Company:北京九恒星科技股份有限公司
 * @Author xiaolong
 * @Date 2020/4/24
 **/
public class ReversePairsNo51 {
    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    a++;
                }
            }
        }
        return a;
    }
}
