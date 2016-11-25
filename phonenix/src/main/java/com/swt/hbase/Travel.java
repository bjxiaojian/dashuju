package com.swt.hbase;
/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class Travel {

    private String ROWKEY;
    private String SP;
    private String EP;
    private String ST;
    private String ET;

    public String getROWKEY() {
        return ROWKEY;
    }

    public void setROWKEY(String ROWKEY) {
        this.ROWKEY = ROWKEY;
    }

    public String getSP() {
        return SP;
    }

    public void setSP(String SP) {
        this.SP = SP;
    }

    public String getEP() {
        return EP;
    }

    public void setEP(String EP) {
        this.EP = EP;
    }

    public String getST() {
        return ST;
    }

    public void setST(String ST) {
        this.ST = ST;
    }

    public String getET() {
        return ET;
    }

    public void setET(String ET) {
        this.ET = ET;
    }
}
