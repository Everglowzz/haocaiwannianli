package com.everglow.mimixiao.bean;

import java.util.List;

/**
 * Created by EverGlow on 2019/6/22 21:32
 */
public class YunShiBean {
    private DataBean data;

    private String msg;

    private int result;

    private String write_result;

    public DataBean getData() { return this.data; }

    public String getMsg() { return this.msg; }

    public int getResult() { return this.result; }

    public String getWrite_result() { return this.write_result; }

    public void setData(DataBean paramDataBean) { this.data = paramDataBean; }

    public void setMsg(String paramString) { this.msg = paramString; }

    public void setResult(int paramInt) { this.result = paramInt; }

    public void setWrite_result(String paramString) { this.write_result = paramString; }

    public static class DataBean {
        private List<ContBean> cont;

        private List<UlBean> ul;

        public List<ContBean> getCont() { return this.cont; }

        public List<UlBean> getUl() { return this.ul; }

        public void setCont(List<ContBean> param1List) { this.cont = param1List; }

        public void setUl(List<UlBean> param1List) { this.ul = param1List; }

        public static class ContBean {
            private String label;

            private String value;

            public String getLabel() { return this.label; }

            public String getValue() { return this.value; }

            public void setLabel(String param2String) { this.label = param2String; }

            public void setValue(String param2String) { this.value = param2String; }
        }

        public static class UlBean {
            private String label;

            private String value;

            public String getLabel() { return this.label; }

            public String getValue() { return this.value; }

            public void setLabel(String param2String) { this.label = param2String; }

            public void setValue(String param2String) { this.value = param2String; }
        }
    }

    public static class ContBean {
        private String label;

        private String value;

        public String getLabel() { return this.label; }

        public String getValue() { return this.value; }

        public void setLabel(String param1String) { this.label = param1String; }

        public void setValue(String param1String) { this.value = param1String; }
    }

    public static class UlBean {
        private String label;

        private String value;

        public String getLabel() { return this.label; }

        public String getValue() { return this.value; }

        public void setLabel(String param1String) { this.label = param1String; }

        public void setValue(String param1String) { this.value = param1String; }
    }
}
