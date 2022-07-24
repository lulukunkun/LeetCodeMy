package com.chuanxi_java.day1;

/**
 * @ClassName Translate_num
 * @Description 已知一个金额数字求翻译
 * 10000
 * 一万元整
 * @Author LuKun
 * @Date 2022/7/18 11:32
 * @Version 1.0
 */


/**
 * 输入的金额转换成中文大写，16位数字精确到小数点后2位数
 *
 */
public class Translate_num {
    private static final String[] CN_NUMBERS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] CN_MONETETARY_UNIT = {"分", "角", "元", "拾", "佰", "仟",
            "万", "拾", "佰", "仟", "亿", "拾",
            "佰", "仟", "兆", "拾", "佰", "仟"};
    private static final String CN_FULL = "整";
    private static final String CN_NEGATIVE = "负";
    private static final String CN_ZERO = "零角零分";
    private static final long MAX_NUMBER = 10000000000000000l;//最大16位整数
    private static final String INVALID_AMOUNT = "金额超出最大金额千兆亿(16位整数)";

    public static void main(String[] args) {
        double amountTest = 1000.12d;
        System.out.println("￥" + amountTest + "=" + formatToCN(amountTest));
    }

    private static String formatToCN(double amountTest) {
        StringBuilder result = new StringBuilder();
        //result.insert()
        return "";
    }


}
class test{
    public static void main(String[] args) {
        System.out.println(11.01*100%10);
    }
}