package com.everglow.mimixiao.bean;
/**
 * Created by EverGlow on 2019/6/22 19:23
 */
import java.util.List;

public class JieMeng {
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

        private String create_time;

        private String name;

        public String getCid() { return this.cid; }

        public String getCreate_time() { return this.create_time; }

        public String getName() { return this.name; }

        public void setCid(String param1String) { this.cid = param1String; }

        public void setCreate_time(String param1String) { this.create_time = param1String; }

        public void setName(String param1String) { this.name = param1String; }
    }
}
