package com.github.yombu.heimdall.example;

import com.github.yombu.heimdall.api.ClusterItem;
import com.google.common.collect.ImmutableMap;

public class PojoConverter
{
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String DESCRIPTION = "description";
    private static final String VERSION = "version";

    public ClusterItem<Integer> fromPojo(Pojo pojo)
    {
        ImmutableMap<String, String> payload = ImmutableMap.of(
            FIRSTNAME, pojo.getFirstname(),
            LASTNAME, pojo.getLastname(),
            DESCRIPTION, pojo.getDescription(),
            VERSION, String.valueOf(pojo.getVersion()));

        return new ClusterItem<>(pojo.getId(), payload);
    }
}