package util.dates.model;

import java.util.Date;

public class EffExpModel {

    private Date effecDate;
    private Date expDate;

    public EffExpModel() {
    }

    public EffExpModel(Date effecDate, Date expDate) {
        this.effecDate = effecDate;
        this.expDate = expDate;
    }

    public Date getEffecDate() {
        return effecDate;
    }

    public void setEffecDate(Date effecDate) {
        this.effecDate = effecDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
}
