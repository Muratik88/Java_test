public class Evidence {
    private String serialNo, cTime;
    private String mValue;
    private String devType;
    private String text;

    public Evidence(String serialNo, String cTime, String mValue, String devType) {
        this.serialNo = serialNo;
        this.cTime = cTime;
        this.mValue = mValue;
        this.devType = devType;
    }


    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public Evidence(){

    }
}
