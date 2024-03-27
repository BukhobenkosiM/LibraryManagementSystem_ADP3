package za.ac.cput.util;

import java.util.UUID;

public class helper {

    //Author: Muneeb Solomons//
//Date: 26 March 2024//

    public static boolean isNullorEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;
    }
    public static String generateName() {
        return UUID.randomUUID().toString();
    }
}