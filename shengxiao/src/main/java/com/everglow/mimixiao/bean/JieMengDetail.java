package com.everglow.mimixiao.bean;

import java.util.List;

/**
 * Created by EverGlow on 2019/6/22 19:43
 */
public    class JieMengDetail   {
    private List<DataBean> data;

    private String msg;

    private int result;

    public List<DataBean> getData() { return this.data; }

    public String getMsg() { return this.msg; }

    public int getResult() { return this.result; }

    public void setData(List<DataBean> paramList) { this.data = paramList; }

    public void setMsg(String paramString) { this.msg = paramString; }

    public void setResult(int paramInt) { this.result = paramInt; }

    public static class DataBean {
        private String cid;

        private String id;

        private String title;

        public DataBean() {}

        public DataBean(String param1String1, String param1String2, String param1String3) {
            this.cid = param1String1;
            this.id = param1String2;
            this.title = param1String3;
        }

        public String getCid() { return this.cid; }

        public String getId() { return this.id; }

        public String getTitle() { return this.title; }

        public void setCid(String param1String) { this.cid = param1String; }

        public void setId(String param1String) { this.id = param1String; }

        public void setTitle(String param1String) { this.title = param1String; }
    }
}
