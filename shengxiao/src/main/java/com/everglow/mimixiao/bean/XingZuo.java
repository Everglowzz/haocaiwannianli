package com.everglow.mimixiao.bean;
/**
 * Created by EverGlow on 2019/6/22 22:06
 */
public class XingZuo  {
    private String riqi;

    private String xingzuo;

    private String xingzuoming;

    public XingZuo() {}

    public XingZuo(String paramString1, String paramString2, String paramString3) {
        this.riqi = paramString1;
        this.xingzuo = paramString2;
        this.xingzuoming = paramString3;
    }

    public String getRiqi() { return this.riqi; }

    public String getXingzuo() { return this.xingzuo; }

    public String getXingzuoming() { return this.xingzuoming; }

    public void setRiqi(String paramString) { this.riqi = paramString; }

    public void setXingzuo(String paramString) { this.xingzuo = paramString; }

    public void setXingzuoming(String paramString) { this.xingzuoming = paramString; }
}
