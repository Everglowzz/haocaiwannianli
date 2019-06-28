package com.everglow.mimixiao;

import java.util.List;

/**
 * Created by EverGlow on 2019/6/21 22:16
 */
public    class ShengXiao   {
    private DataBean data;

    public DataBean getData() { return this.data; }

    public void setData(DataBean paramDataBean) { this.data = paramDataBean; }

    public static class DataBean {
        private List<BiaoQianBean> biaoQian;

        private List<ShengXiaoJieDuBean> shengXiaoJieDu;

        private List<ZhuanTiDaQuanBean> zhuanTiDaQuan;

        public List<BiaoQianBean> getBiaoQian() { return this.biaoQian; }

        public List<ShengXiaoJieDuBean> getShengXiaoJieDu() { return this.shengXiaoJieDu; }

        public List<ZhuanTiDaQuanBean> getZhuanTiDaQuan() { return this.zhuanTiDaQuan; }

        public void setBiaoQian(List<BiaoQianBean> param1List) { this.biaoQian = param1List; }

        public void setShengXiaoJieDu(List<ShengXiaoJieDuBean> param1List) { this.shengXiaoJieDu = param1List; }

        public void setZhuanTiDaQuan(List<ZhuanTiDaQuanBean> param1List) { this.zhuanTiDaQuan = param1List; }

        public static class BiaoQianBean {
            private String des;

            private String text;

            private String title;

            public String getDes() { return this.des; }

            public String getText() { return this.text; }

            public String getTitle() { return this.title; }

            public void setDes(String param2String) { this.des = param2String; }

            public void setText(String param2String) { this.text = param2String; }

            public void setTitle(String param2String) { this.title = param2String; }
        }

        public static class ShengXiaoJieDuBean {
            private String title;

            private String url;

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setTitle(String param2String) { this.title = param2String; }

            public void setUrl(String param2String) { this.url = param2String; }
        }

        public static class ZhuanTiDaQuanBean {
            private String title;

            private String url;

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setTitle(String param2String) { this.title = param2String; }

            public void setUrl(String param2String) { this.url = param2String; }
        }
    }

    public static class BiaoQianBean {
        private String des;

        private String text;

        private String title;

        public String getDes() { return this.des; }

        public String getText() { return this.text; }

        public String getTitle() { return this.title; }

        public void setDes(String param1String) { this.des = param1String; }

        public void setText(String param1String) { this.text = param1String; }

        public void setTitle(String param1String) { this.title = param1String; }
    }

    public static class ShengXiaoJieDuBean {
        private String title;

        private String url;

        public String getTitle() { return this.title; }

        public String getUrl() { return this.url; }

        public void setTitle(String param1String) { this.title = param1String; }

        public void setUrl(String param1String) { this.url = param1String; }
    }

    public static class ZhuanTiDaQuanBean {
        private String title;

        private String url;

        public String getTitle() { return this.title; }

        public String getUrl() { return this.url; }

        public void setTitle(String param1String) { this.title = param1String; }

        public void setUrl(String param1String) { this.url = param1String; }
    }
}
