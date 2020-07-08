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
                name = "report_by_railroad",
                procedureName = "wb_sum_test",
                //resultClasses = {Authority.class},
                parameters = {
                        @StoredProcedureParameter(name = "wbSumCur", type = Class.class, mode = ParameterMode.REF_CURSOR),
                        @StoredProcedureParameter(name = "road", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "beginDate", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "endDate", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "orderBy", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "waybillStatus", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "pageSize", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "pagestartNum", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "isFullList", type = String.class, mode = ParameterMode.IN)
                }
        )
)
public class SPModel {
    @Id
    private int id;
    @Column(name = "URRWIN")
    private String urrwin;
    @Column(name = "URRWIN_DATE")
    private String urrwinDate;
    @Column(name = "LEAD_CAR_INITIALS")
    private String leadcarInitials;
    private String fromScac;
    @Column(name = "ORIGIN_FSAC")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrrwin() {
        return urrwin;
    }

    public void setUrrwin(String urrwin) {
        this.urrwin = urrwin;
    }

    public String getUrrwinDate() {
        return urrwinDate;
    }

    public void setUrrwinDate(String urrwinDate) {
        this.urrwinDate = urrwinDate;
    }

    public String getLeadcarInitials() {
        return leadcarInitials;
    }

    public void setLeadcarInitials(String leadcarInitials) {
        this.leadcarInitials = leadcarInitials;
    }
}
