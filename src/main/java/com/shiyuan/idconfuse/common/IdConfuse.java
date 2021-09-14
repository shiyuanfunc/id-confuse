package com.shiyuan.idconfuse.common;

/**
 * ID 异或方式混淆
 * @author shiyuan
 */
public class IdConfuse {

    private static final Integer xor = 4;

    private static final Long hex = 12345L;
    // 丢失去精度
    public static Integer encryptConfuse(Integer num){
        int i = num << xor;
        long l = i ^ hex;
        return (int)(((long)num << xor) ^ hex);
    }

    public static Integer decryptConfuse(Integer num){
        return (int)((num ^ hex) >> xor);
    }

    public static boolean isequal(Integer num){
        return decryptConfuse(encryptConfuse(num)).equals(num);
    }

    public static void main(String[] args) {
        System.out.println(isequal(1));
        System.out.println(isequal(-1));
        System.out.println(isequal(-100));
        System.out.println(isequal(100));
        System.out.println(isequal(Integer.MAX_VALUE));
        System.out.println(isequal(Integer.MIN_VALUE));
    }
}
