package com.ops;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastOperation {

    public static final String CUSTOMER_MAP = "CUSTOMER_MAP";
    public static final String USER_LIST_MAP = "USER_LIST_MAP";

    private HazelcastInstance instance;

    {
        Config cfg = new Config();
        instance = Hazelcast.newHazelcastInstance(cfg);
    }

    public HazelcastInstance getInstance() {
        return instance;
    }
}
