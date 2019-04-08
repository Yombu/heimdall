package com.github.yombu.heimdall.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.github.yombu.heimdall.api.ClusterStore;
import com.google.common.collect.Maps;

public class InMemoryClusterStore implements ClusterStore<Integer, InMemoryCluster>
{
    private Map<Long, InMemoryCluster> clusters = Maps.newHashMap();

    @Override
    public InMemoryCluster create(
        Integer representativeId, Map<String, Double> spanningVector, List<Integer> memberIds)
    {
        InMemoryCluster result = new InMemoryCluster();
        result.setRepresentativeId(representativeId);
        result.setSpanningVector(spanningVector);
        result.setMemberIds(memberIds);
        result.setVersion(System.currentTimeMillis());

        clusters.put(result.getVersion(), result);
        return result;
    }

    @Override
    public Stream list()
    {
        return clusters.values().stream();
    }

    @Override
    public void update(InMemoryCluster cluster)
    {
        clusters.replace(cluster.getVersion(), cluster);
    }
}