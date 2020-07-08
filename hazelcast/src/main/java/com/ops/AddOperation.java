package com.ops;

import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.core.IMap;
import com.model.RatesUser;
import com.model.UserList;

public class AddOperation {

    public void addStringNames(HazelcastOperation operation) {
        IMap<String, RatesUser> mapCustomers = operation.getInstance().getMap(HazelcastOperation.CUSTOMER_MAP);

        RatesUser chamly = new RatesUser("Chamly", 35, "Rates");
        RatesUser isuru = new RatesUser("Isuru", 37, "Rates");

        mapCustomers.put(chamly.getName(), chamly);
//        mapCustomers.lock(chamly.getName());
        mapCustomers.put(isuru.getName(), isuru);
//        mapCustomers.lock(isuru.getName());
//
//        mapCustomers.unlock("Chamly");
//        RatesUser chamlyFromMap = mapCustomers.get("Chamly");
//        System.out.println(chamlyFromMap);
//
//
//        UserList userList = new UserList();
//        userList.addUser(chamly);
//        userList.addUser(isuru);
//
//        IMap<String, UserList> userListMap = operation.getInstance().getMap(HazelcastOperation.USER_LIST_MAP);
//        userListMap.put("First", userList);
//
//        chamly.setAge(40);
//
//        userListMap.lock("First");
//        userListMap.unlock("First");
//        UserList firstList = userListMap.get("First");
//
//        System.out.println(firstList);

    }

    public static void main(String[] args) {
        HazelcastOperation hazelcastOperation = new HazelcastOperation();
        AddOperation addOperation = new AddOperation();
        addOperation.addStringNames(hazelcastOperation);
        //addOperation.addStringNames(hazelcastOperation);
    }
}
