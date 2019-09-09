package com.dp;

public class MinCoinNumber {
    public static void main(String[] args) {
        int[] coinValue = new int[]{1, 3, 5};
        int money = 20;
        int[] coinsUsed = new int[money + 1];
        makeChange(coinValue, money, coinsUsed);
    }

    public static void makeChange(int[] values, int money, int[] coinsUsed){
        int valueKinds = values.length;
        coinsUsed[0] = 0;
        // 对每一分钱都找零，即保存子问题的解以备用，即填表
        for (int cents = 1; cents <= money; cents++) {
            // 当用最小币值的硬币找零时，所需硬币数量最多
            int minCoins = cents;
            // 遍历每一种面值的硬币，看是否可作为找零的其中之一
            for (int kind = 0; kind < valueKinds; kind++) {
                // 若当前面值的硬币小于当前的cents则分解问题并查表
                if (values[kind] <= cents) {
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    System.out.print(temp + "==");
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            // 保存最小硬币数
            coinsUsed[cents] = minCoins;

            System.out.println("面值为 " + (cents) + " 的最小硬币数 : "
                    + coinsUsed[cents]);
        }
    }
}
