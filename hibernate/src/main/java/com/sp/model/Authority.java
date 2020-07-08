package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITY_2")
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                /*
                SP :
                CREATE OR REPLACE PROCEDURE sp_auth_by_id (authRef OUT SYS_REFCURSOR, auth_id IN NUMBER)
                AS
                    select_sql varchar2(2000);
                BEGIN
                    select_sql := 'select * from authority_2 where id = :auth_id';
                    OPEN authRef FOR select_sql USING auth_id;
                END;
                 */
                name = "auth_by_id",
                procedureName = "sp_auth_by_id",
                resultClasses = {Authority.class},
                parameters = {
                        @StoredProcedureParameter(name = "authRef", type = Class.class, mode = ParameterMode.REF_CURSOR),
                        @StoredProcedureParameter(name = "auth_id", type = Integer.class, mode = ParameterMode.IN)
                }
        )
)
public class Authority {
    @Id
    @Column(name = "ID", unique = true)
    private int id;
    @Column(name = "AUTHORITY_NUMBER")
    private String authorityNumber;
}
