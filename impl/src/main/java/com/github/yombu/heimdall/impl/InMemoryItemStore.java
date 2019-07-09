package com.github.yombu.heimdall.impl;

import java.util.List;

import javax.annotation.Nonnull;

import com.github.yombu.heimdall.api.ClusterItem;
import com.github.yombu.heimdall.api.ItemStore;
import com.google.common.collect.Lists;

public class InMemoryItemStore implements ItemStore<Integer>
{
    private List<ClusterItem<Integer>> clusterItems = Lists.newArrayList();

    @Nonnull
    @Override
    public ClusterItem<Integer> read(Integer id)
    {
        return clusterItems.get(id);
    }

    public void add(ClusterItem<Integer> item)
    {
        clusterItems.add(item);
    }
}