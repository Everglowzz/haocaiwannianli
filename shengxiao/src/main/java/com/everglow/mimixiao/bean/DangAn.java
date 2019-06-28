package com.everglow.mimixiao.bean;

import java.util.List;

/**
 * Created by EverGlow on 2019/6/22 22:10
 */
public    class DangAn   {
    private BaiyangBean baiyang;

    public BaiyangBean getBaiyang() { return this.baiyang; }

    public void setBaiyang(BaiyangBean paramBaiyangBean) { this.baiyang = paramBaiyangBean; }

    public static class BaiyangBean {
        private List<BiaoQianBean> biaoQian;

        private List<GuanJianZiBean> guanJianZi;

        private JieXiBean jieXi;

        private List<YueHuiBean> yueHui;

        public List<BiaoQianBean> getBiaoQian() { return this.biaoQian; }

        public List<GuanJianZiBean> getGuanJianZi() { return this.guanJianZi; }

        public JieXiBean getJieXi() { return this.jieXi; }

        public List<YueHuiBean> getYueHui() { return this.yueHui; }

        public void setBiaoQian(List<BiaoQianBean> param1List) { this.biaoQian = param1List; }

        public void setGuanJianZi(List<GuanJianZiBean> param1List) { this.guanJianZi = param1List; }

        public void setJieXi(JieXiBean param1JieXiBean) { this.jieXi = param1JieXiBean; }

        public void setYueHui(List<YueHuiBean> param1List) { this.yueHui = param1List; }

        public static class BiaoQianBean {
            private String text;

            private String title;

            public String getText() { return this.text; }

            public String getTitle() { return this.title; }

            public void setText(String param2String) { this.text = param2String; }

            public void setTitle(String param2String) { this.title = param2String; }
        }

        public static class GuanJianZiBean {
            private String text;

            private String title;

            private String url;

            public String getText() { return this.text; }

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setText(String param2String) { this.text = param2String; }

            public void setTitle(String param2String) { this.title = param2String; }

            public void setUrl(String param2String) { this.url = param2String; }
        }

        public static class JieXiBean {
            private List<AiQingBean> aiQing;

            private List<GeXingBean> geXing;

            private List<KaiYunBean> kaiYun;

            public List<AiQingBean> getAiQing() { return this.aiQing; }

            public List<GeXingBean> getGeXing() { return this.geXing; }

            public List<KaiYunBean> getKaiYun() { return this.kaiYun; }

            public void setAiQing(List<AiQingBean> param2List) { this.aiQing = param2List; }

            public void setGeXing(List<GeXingBean> param2List) { this.geXing = param2List; }

            public void setKaiYun(List<KaiYunBean> param2List) { this.kaiYun = param2List; }

            public static class AiQingBean {
                private String title;

                private String url;

                public String getTitle() { return this.title; }

                public String getUrl() { return this.url; }

                public void setTitle(String param3String) { this.title = param3String; }

                public void setUrl(String param3String) { this.url = param3String; }
            }

            public static class GeXingBean {
                private String title;

                private String url;

                public String getTitle() { return this.title; }

                public String getUrl() { return this.url; }

                public void setTitle(String param3String) { this.title = param3String; }

                public void setUrl(String param3String) { this.url = param3String; }
            }

            public static class KaiYunBean {
                private String title;

                private String url;

                public String getTitle() { return this.title; }

                public String getUrl() { return this.url; }

                public void setTitle(String param3String) { this.title = param3String; }

                public void setUrl(String param3String) { this.url = param3String; }
            }
        }

        public static class AiQingBean {
            private String title;

            private String url;

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setTitle(String param2String) { this.title = param2String; }

            public void setUrl(String param2String) { this.url = param2String; }
        }

        public static class GeXingBean {
            private String title;

            private String url;

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setTitle(String param2String) { this.title = param2String; }

            public void setUrl(String param2String) { this.url = param2String; }
        }

        public static class KaiYunBean {
            private String title;

            private String url;

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setTitle(String param2String) { this.title = param2String; }

            public void setUrl(String param2String) { this.url = param2String; }
        }

        public static class YueHuiBean {
            private String title;

            private String url;

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setTitle(String param2String) { this.title = param2String; }

            public void setUrl(String param2String) { this.url = param2String; }
        }
    }

    public static class BiaoQianBean {
        private String text;

        private String title;

        public String getText() { return this.text; }

        public String getTitle() { return this.title; }

        public void setText(String param1String) { this.text = param1String; }

        public void setTitle(String param1String) { this.title = param1String; }
    }

    public static class GuanJianZiBean {
        private String text;

        private String title;

        private String url;

        public String getText() { return this.text; }

        public String getTitle() { return this.title; }

        public String getUrl() { return this.url; }

        public void setText(String param1String) { this.text = param1String; }

        public void setTitle(String param1String) { this.title = param1String; }

        public void setUrl(String param1String) { this.url = param1String; }
    }

    public static class JieXiBean {
        private List<AiQingBean> aiQing;

        private List<GeXingBean> geXing;

        private List<KaiYunBean> kaiYun;

        public List<AiQingBean> getAiQing() { return this.aiQing; }

        public List<GeXingBean> getGeXing() { return this.geXing; }

        public List<KaiYunBean> getKaiYun() { return this.kaiYun; }

        public void setAiQing(List<AiQingBean> param1List) { this.aiQing = param1List; }

        public void setGeXing(List<GeXingBean> param1List) { this.geXing = param1List; }

        public void setKaiYun(List<KaiYunBean> param1List) { this.kaiYun = param1List; }

        public static class AiQingBean {
            private String title;

            private String url;

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setTitle(String param3String) { this.title = param3String; }

            public void setUrl(String param3String) { this.url = param3String; }
        }

        public static class GeXingBean {
            private String title;

            private String url;

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setTitle(String param3String) { this.title = param3String; }

            public void setUrl(String param3String) { this.url = param3String; }
        }

        public static class KaiYunBean {
            private String title;

            private String url;

            public String getTitle() { return this.title; }

            public String getUrl() { return this.url; }

            public void setTitle(String param3String) { this.title = param3String; }

            public void setUrl(String param3String) { this.url = param3String; }
        }
    }

    public static class AiQingBean {
        private String title;

        private String url;

        public String getTitle() { return this.title; }

        public String getUrl() { return this.url; }

        public void setTitle(String param1String) { this.title = param1String; }

        public void setUrl(String param1String) { this.url = param1String; }
    }

    public static class GeXingBean {
        private String title;

        private String url;

        public String getTitle() { return this.title; }

        public String getUrl() { return this.url; }

        public void setTitle(String param1String) { this.title = param1String; }

        public void setUrl(String param1String) { this.url = param1String; }
    }

    public static class KaiYunBean {
        private String title;

        private String url;

        public String getTitle() { return this.title; }

        public String getUrl() { return this.url; }

        public void setTitle(String param1String) { this.title = param1String; }

        public void setUrl(String param1String) { this.url = param1String; }
    }

    public static class YueHuiBean {
        private String title;

        private String url;

        public String getTitle() { return this.title; }

        public String getUrl() { return this.url; }

        public void setTitle(String param1String) { this.title = param1String; }

        public void setUrl(String param1String) { this.url = param1String; }
    }
}
