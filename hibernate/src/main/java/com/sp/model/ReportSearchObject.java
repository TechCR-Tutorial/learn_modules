package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                name = "daily_settlement",
                procedureName = "concur.PKG_CONCUR_FUNDS_TRANSFER_R.daily_settlement",
                //resultClasses = {Authority.class},
                parameters = {
                        @StoredProcedureParameter(name = "dailyStlCur", type = Class.class, mode = ParameterMode.REF_CURSOR),
                        @StoredProcedureParameter(name = "road", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "beginDate", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "endDate", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "partnerRoad", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "transferType", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "orderBy", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "pageSize", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "pagestartNum", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "isFullList", type = String.class, mode = ParameterMode.IN)
                }
        )
)
public class ReportSearchObject {
    @Id
    private Integer id;
    @Column(name = "roadmark")
    private String roadMark;
    @Column(name = "urrwin")
    private String urrwin;
    @Column(name = "urrwin_version")
    private String urrwinVersion;
    @Column(name = "lead_car_initials")
    private String equipInitials; // leadCarInitials;
    @Column(name = "lead_car_num")
    private String leadCarNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoadMark() {
        return roadMark;
    }

    public void setRoadMark(String roadMark) {
        this.roadMark = roadMark;
    }

    public String getUrrwin() {
        return urrwin;
    }

    public void setUrrwin(String urrwin) {
        this.urrwin = urrwin;
    }

    public String getUrrwinVersion() {
        return urrwinVersion;
    }

    public void setUrrwinVersion(String urrwinVersion) {
        this.urrwinVersion = urrwinVersion;
    }

    public String getEquipInitials() {
        return equipInitials;
    }

    public void setEquipInitials(String equipInitials) {
        this.equipInitials = equipInitials;
    }

    public String getLeadCarNum() {
        return leadCarNum;
    }

    public void setLeadCarNum(String leadCarNum) {
        this.leadCarNum = leadCarNum;
    }
}
