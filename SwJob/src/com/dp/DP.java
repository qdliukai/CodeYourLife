package com.dp;

public class DP {
    public static void main(String[] args) {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";
        int array = MaxTwoArraySameOrderMethod(str1,str2);
        System.out.println(array);
    }

    // 1、数组最大连续子序列和
    //如arr[] = {6,-1,3,-4,-6,9,2,-2,5}的最大连续子序列和为14。即为：9,2,-2,5
    //创建一个数组a，长度为原数组长度，不同位置数字a[i]代表0...i上最大连续子序列和
    // a[0]=arr[0]设置一个最大值max，初始值为数组中的第一个数字。当进来一个新的数字arr[i+1]时
    // 判断到他前面数字子序列和a[i]+arr[i+1]跟arr[i+1]哪个大
    // 前者大就保留前者，后者大就说明前面连续数字加起来都不如后者一个新进来的数字大，前面数字就可以舍弃
    // 从arr[i+1]开始，每次比较完都跟max比较一下，最后的max就是最大值。
    public static int MaxContinueArraySum(int a[]) {
        int n = a.length;
        int max = a[0];
        int sum = a[0];
        for(int i=1;i<n;i++){
            sum = Math.max(sum+a[i], a[i]);
            if(sum>=max){
                max = sum;
            }
        }
        return max;
    }


    public static int MaxTwoArraySameOrderMethod(String str1,String str2) {
        int m = str1.length();
        int n = str2.length();
        /*
         * 定义一个二维数组保存公共子序列长度
         * dp[i][j]表示字符串1从头开始长度是i，字符串2从头开始长度是j，这两个字符串的最长公共子序列的长度
         * 设置数组行列比他们长度大一往二维数组中填写数字时，每个位置的数字跟他上方或者左方或者左上方数字有关系，这样处理边界数字时不用处理这种情况，方便接下来的循环
         */
        int dp[][] = new int[m+1][n+1];
        /*
         * 初始化第一行第一列
         * dp[0,j]表示啥？表示字符串1的长度是0，字符串2的长度是j，这两个字符串的最长公共子序列的长度是0，因为，字符串1 根本就没有嘛
         */
        for(int i=0;i<=m;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                /*
                 * 如果当c[i][j]时，字符串1从头开始长度是i，字符串2从头开始长度是j时他们最后一个字符相同
                 * 就同时把他们向前移动一位，找c[i-1][j-1]时长度最大的再加一
                 * 表现在二维数组中就是c[i][j]左上方的点
                 */
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    /*
                     * 如果当c[i][j]时，他们最后一个字符不相同
                     * 要将str1往前移动一位的c[i-1][j]的lcs长度，或者将str2往前移动一位的c[i][j-1]的lcs长度
                     * 哪个长，将它赋给c[i][j]
                     * 表现在二维数组中就是c[i][j]上方的点或者左方的点
                     */
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
