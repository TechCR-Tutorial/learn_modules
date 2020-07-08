package com.sp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sp.model.Authority;
import com.sp.model.ReportSearchObject;
import com.sp.model.SPModel;

public class Main {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JavaHelps");

    public static void main(String[] args) {
//        findAuthority();
//        finAuthorityByID();
//        findReport();
        dailyReport();
    }

    public static void dailyReport() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        try {
            List<ReportSearchObject> postComments = entityManager
                    .createNamedStoredProcedureQuery( "daily_settlement" )
                    .setParameter( "road", "IHB" )
                    .setParameter( "beginDate", "07-01-2019" )
                    .setParameter( "endDate", "07-31-2019" )
                    .setParameter( "partnerRoad", "EQUIPMENT" )
                    .setParameter( "transferType", "all" )
                    .setParameter( "orderBy", "all" )
                    .setParameter( "pageSize", 75 )
                    .setParameter( "isFullList", "" )
                    .setParameter( "pagestartNum", 0 )
                    .getResultList();
            System.out.println(postComments);
        } finally {
            entityManager.close();
        }
    }

    public static void findReport() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        try {
            List<SPModel> postComments = entityManager
                    .createNamedStoredProcedureQuery( "report_by_railroad" )
                    .setParameter( "road", "IHB" )
                    .setParameter( "beginDate", "07-01-2019" )
                    .setParameter( "endDate", "07-31-2019" )
                    .setParameter( "orderBy", "" )
                    .setParameter( "waybillStatus", "all" )
                    .setParameter( "pageSize", 75 )
                    .setParameter( "pagestartNum", 0 )
                    .setParameter( "isFullList", "" )
                    .getResultList();
            System.out.println(postComments);
        } finally {
            entityManager.close();
        }
    }

    public static void finAuthorityByID() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        try {
            List<Authority> postComments = entityManager
                    .createNamedStoredProcedureQuery( "auth_by_id" )
                    .setParameter( "auth_id", 542 )
                    .getResultList();
            System.out.println(postComments);
        } finally {
            entityManager.close();
        }
    }

    public static void findAuthority() {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            List<Authority>  authorities = manager.
                    createNativeQuery("select * from authority_2 where id = 542", Authority.class).
                    getResultList();
            System.out.println(authorities.size());
            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }
}
