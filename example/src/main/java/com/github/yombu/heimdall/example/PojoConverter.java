package com.github.yombu.heimdall.example;

import java.util.HashMap;

import com.github.yombu.heimdall.api.ClusterItem;
import com.google.common.collect.Maps;

public class PojoConverter
{
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String DESCRIPTION = "description";
    private static final String VERSION = "version";

    public ClusterItem<Integer> fromPojo(Pojo pojo)
    {
        ClusterItem<Integer> result = new ClusterItem<>();

        HashMap<String, String> payload = Maps.newHashMap();
        payload.put(FIRSTNAME, pojo.getFirstname());
        payload.put(LASTNAME, pojo.getLastname());
        payload.put(DESCRIPTION, pojo.getDescription());
        payload.put(VERSION, String.valueOf(pojo.getVersion()));

        result.setId(pojo.getId());
        result.setPayload(payload);

        return result;
    }

    public Pojo toPojo(ClusterItem<Integer> clusterItem)
    {
        Pojo result = new Pojo();

        result.setId(clusterItem.getId());
        result.setFirstname(clusterItem.getPayload().get(FIRSTNAME));
        result.setLastname(clusterItem.getPayload().get(LASTNAME));
        result.setDescription(clusterItem.getPayload().get(DESCRIPTION));
        result.setVersion(Integer.valueOf(clusterItem.getPayload().get(VERSION)));

        return result;
    }
}