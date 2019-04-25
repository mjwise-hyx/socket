package com.heyx.socket.util;

import java.math.BigInteger;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-25 14:07
 * @email; 1064042411@qq.com
 */
public class CRCUtil {

    public static int getCRC(String data212)
    {
        int CRC = 0xFFFF;
        int Num = 0xA001;
        int inum = 0;
        int length = data212.length();
        for (int j = 0; j < length; j++)
        {
            inum = data212.charAt(j);
            CRC = (CRC >> 8) & 0x00FF;
            CRC ^= inum;

            for (int k = 0; k < 8; k++)
            {
                int flag = CRC % 2;
                CRC = CRC >> 1;

                if (flag == 1)
                {
                    CRC = CRC ^ Num;
                }
            }
        }
        return CRC;
    }


    //使用1字节就可以表示b
    public static String numToHex8(int b) {
        return String.format("%02x", b);//2表示需要两个16进行数
    }
    //需要使用2字节表示b
    public static String numToHex16(int b) {
        return String.format("%04x", b);
    }
    //需要使用4字节表示b
    public static String numToHex32(int b) {
        return String.format("%08x", b);
    }

    public static String getIntHex(int a){
        return toHex(getIntBit(a));
    }

    public static String getIntegerHex(int a, int radix){
        return new BigInteger(String.valueOf(a), radix).toString();
    }

    /**
     * 将byte转换为一个长度为32的byte数组，数组每个值代表bit
     */
    private static byte[] getIntBit(int b) {
        byte[] array = new byte[32];
        for (int i = 31; i >= 0; i--) {
            array[i] = (byte)(b & 1);
            b = (byte) (b >> 1);
        }
        return array;
    }

    /**
     * 转16进制
     */
    private static String toHex(byte[] b) {
        String s = "";
        //每四位处理一次
        for(int i = 0; i < 32; i += 4) {
            int temp = (b[i] * 8  + b[i+1] * 4 + b[i+2] * 2 + b[i+3]);

            if(temp > 9) {
                temp += 55;
                s += (char)temp;
            }else {
                s += temp;
            }
        }
        return s;
    }
    /**
     * 转十进制
     */
    private static int toDec(String s) {
        int result = 0;
        for(int i = 0; i < 8; i++) {
            int temp = s.charAt(i);
            //9的ascii为57
            if(temp > 57) {
                temp -= 55; //'A'为65对应10，故减去55
            }else {
                temp -= 48;
            }
            result += temp * getProduct(7 - i);
        }
        return result;
    }
    /**
     * 计算16的n次方　
     */
    private static int getProduct(int n) {
        int result = 1;
        for(int i = 0; i < n; i++) {
            result *= 16;
        }
        return result;
    }

}
