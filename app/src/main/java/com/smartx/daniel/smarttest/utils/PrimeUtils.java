package com.smartx.daniel.smarttest.utils;

/**
 * created by daniel on 2018/12/6
 * <p>
 * 在给定数内求质数个数
 * 要放在子线程中计算
 */
public class PrimeUtils {

    /**
     * 方式一：
     *
     * @param num 要计算的数
     * @return 质数的个数
     */
    public static int getPrimCount1(int num) {
        if (num < 2) {
            return 0;
        } else if (num <= 3) {
            return num - 1;
        }
        boolean[] isPrime = new boolean[num + 1]; //假设全不是
        for (int i = 3; i < num; i += 2) {
            if (i % 3 != 0) {
                isPrime[i] = true;                // 筛选 假设去掉偶数和3的倍数 其余全是质数 只剩下奇数
            }
        }
        isPrime[2] = true;
        isPrime[3] = true;
        int result = 0;
        for (int i = 3; i <= Math.sqrt(num); i += 2) { // 因数成对出现 如100的因数有：1和100，2和50，4和25，5和20,10和10。成对的因数，其中一个必然小于等于100的开平方，另一个大于等于100的开平方
            if (isPrime[i]) {
                for (int j = i * i; j <= num; j += i * 2) { // 当num比较大时 j += i * 2 会有很多重复的操作  优化后见方式二
                    isPrime[j] = false;    //去除 这些奇数中能平方的数及倍数
                }
            }
        }
        for (int j = 1; j < num; j++) {
            if (isPrime[j]) {
                result++;
//                Logger.d("the prime is ->" + j);
            }
        }
//        Logger.d("the prime numb is " + result);
        return result;
    }


    /**
     * 方式二：
     *
     * @param num 要计算的数
     * @return 质数的个数
     */
    public static int getPrimCount2(int num) {

        boolean[] isPrime = new boolean[num + 1]; //假设全不是
        for (int i = 3; i < num; i += 2) {
            if (i % 3 != 0) {
                isPrime[i] = true;                // 筛选 假设去掉偶数和3的倍数 其余全是质数 只剩下奇数
            }
        }
        isPrime[2] = true;
        isPrime[3] = true;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (isPrime[i]) {
                int j = i * i;
                int k = i;
                while (j <= num) {
                    isPrime[j] = false;
                    while (j * i <= num) {
                        isPrime[j*=i] = false;
                    }
                    k += 2;
                    if (!isPrime[k]) {
                        k += 2;
                    }
                    j = k * i;
                }
            }
        }
        int result = 0;
        for (int j = 1; j < num; j++) {
            if (isPrime[j]) {
                result++;
            }
        }
        return result;
    }

    /**
     * 方式三：欧拉筛选  适合千万级别以上的数
     *  缺点:两个数组会很耗内存 优化？
     * @param num 要计算的数
     * @return 质数的个数
     */
    public static int getPrimCount3(int num) {

        boolean[] isPrime = new boolean[num + 1]; //假设全不是
        int[]     prime   = new int[num / 10];
        int       result  = 1;
        for (int i = 3; i < num; i += 2) {
            if (i % 3 != 0) {
                isPrime[i] = true;                // 筛选 假设去掉偶数和3的倍数 其余全是质数 只剩下奇数
            }
        }
        isPrime[2] = true;
        isPrime[3] = true;
        prime[0] = 2;
        for (int i = 3; i <= num; i += 2) {
            if(isPrime[i]){
                prime[result++] = i;
            }
            for (int j = 1; i*prime[j] <= num && j<result; j++) {
                isPrime[i*prime[j]]  = false;
                if(i%prime[j] == 0){
                    break;
                }
            }
        }
        Logger.d("the prime nub is="+result);
        return result;
    }
}




