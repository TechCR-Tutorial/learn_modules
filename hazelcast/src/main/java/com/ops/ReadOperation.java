package com.ops;

import java.util.Map;

import com.hazelcast.core.IMap;
import com.model.RatesUser;

public class ReadOperation {

    public static void main(String[] args) {
        HazelcastOperation hazelcastOperation = new HazelcastOperation();
        IMap<String, RatesUser> mapCustomers = hazelcastOperation.getInstance().getMap(HazelcastOperation.CUSTOMER_MAP);
        System.out.println(mapCustomers.size());
//        mapCustomers.unlock("Chamly");
        RatesUser chamly = mapCustomers.get("Chamly");
        System.out.println(chamly);
    }
}
