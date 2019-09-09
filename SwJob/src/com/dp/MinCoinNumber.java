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
        // ��ÿһ��Ǯ�����㣬������������Ľ��Ա��ã������
        for (int cents = 1; cents <= money; cents++) {
            // ������С��ֵ��Ӳ������ʱ������Ӳ���������
            int minCoins = cents;
            // ����ÿһ����ֵ��Ӳ�ң����Ƿ����Ϊ���������֮һ
            for (int kind = 0; kind < valueKinds; kind++) {
                // ����ǰ��ֵ��Ӳ��С�ڵ�ǰ��cents��ֽ����Ⲣ���
                if (values[kind] <= cents) {
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    System.out.print(temp + "==");
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            // ������СӲ����
            coinsUsed[cents] = minCoins;

            System.out.println("��ֵΪ " + (cents) + " ����СӲ���� : "
                    + coinsUsed[cents]);
        }
    }
}
