package com.example.wannianli;

/**
 * Created by YougaKing on 2016/10/11.
 */

public class AuspiciousCalendarForm {
    int code;
    String message;
    String[] dayarray;
    HuangLi huangli;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String[] getDayarray() {
        return dayarray;
    }

    public static class HuangLi {

        String ok;
        String no;

        public String getOk() {
            return ok;
        }

        public String getNo() {
            return no;
        }
    }

    public HuangLi getHuangli() {
        return huangli;
    }
}
