package com.github.yombu.heimdall.impl;

import java.util.Map;

import javax.annotation.Nonnull;

import com.github.yombu.heimdall.api.ClusterItem;
import com.github.yombu.heimdall.api.ItemStore;
import com.google.common.collect.Maps;

public class InMemoryItemStore implements ItemStore<Integer>
{
    private Map<Integer, ClusterItem<Integer>> clusterItems = Maps.newHashMap();

    @Nonnull
    @Override
    public ClusterItem<Integer> read(Integer id)
    {
        return clusterItems.get(id);
    }

    public void put(ClusterItem<Integer> item)
    {
        clusterItems.put(item.getId(), item);
    }
}