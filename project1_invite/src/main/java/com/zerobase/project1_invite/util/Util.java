package com.zerobase.project1_invite.util;

import java.util.Locale;
import java.util.UUID;

public class Util {

    public Util() {
    }

    public static String generateUUID() {
        String s = null;

        do {
            do {
                s = UUID.randomUUID().toString().toLowerCase(Locale.ROOT).replace("-", "");
            } while(s.equals("00000000000000000000000000000000"));
        } while(s.equals("ffffffffffffffffffffffffffffffff"));

        return s;
    }

}