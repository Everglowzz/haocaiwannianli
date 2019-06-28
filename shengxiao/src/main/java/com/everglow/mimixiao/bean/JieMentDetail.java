package com.everglow.mimixiao.bean;

import java.util.List;

/**
 * Created by EverGlow on 2019/6/22 20:25
 */
public    class JieMentDetail   {
    private DataBean data;

    private String msg;

    private int result;

    public DataBean getData() { return this.data; }

    public String getMsg() { return this.msg; }

    public int getResult() { return this.result; }

    public void setData(DataBean paramDataBean) { this.data = paramDataBean; }

    public void setMsg(String paramString) { this.msg = paramString; }

    public void setResult(int paramInt) { this.result = paramInt; }

    public static class DataBean {
        private String cid;

        private List<ContentBean> content;

        private String id;

        private String name;

        private String title;

        public String getCid() { return this.cid; }

        public List<ContentBean> getContent() { return this.content; }

        public String getId() { return this.id; }

        public String getName() { return this.name; }

        public String getTitle() { return this.title; }

        public void setCid(String param1String) { this.cid = param1String; }

        public void setContent(List<ContentBean> param1List) { this.content = param1List; }

        public void setId(String param1String) { this.id = param1String; }

        public void setName(String param1String) { this.name = param1String; }

        public void setTitle(String param1String) { this.title = param1String; }

        public static class ContentBean {
            private String content;

            private String title;

            public String getContent() { return this.content; }

            public String getTitle() { return this.title; }

            public void setContent(String param2String) { this.content = param2String; }

            public void setTitle(String param2String) { this.title = param2String; }
        }
    }

    public static class ContentBean {
        private String content;

        private String title;

        public String getContent() { return this.content; }

        public String getTitle() { return this.title; }

        public void setContent(String param1String) { this.content = param1String; }

        public void setTitle(String param1String) { this.title = param1String; }
    }
}
