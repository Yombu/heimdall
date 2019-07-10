package com.github.yombu.heimdall.impl;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import com.github.mizool.core.exception.DataInconsistencyException;
import com.github.yombu.heimdall.api.ClusterStore;
import com.google.common.collect.Maps;

public class InMemoryClusterStore implements ClusterStore<Integer, InMemoryCluster>
{
    private Random random = new Random();
    private Map<Long, InMemoryCluster> clusters = Maps.newHashMap();

    @Override
    public InMemoryCluster create(
        Integer representativeId, Map<String, Double> spanningVector, List<Integer> memberIds)
    {
        InMemoryCluster result = new InMemoryCluster();
        result.setId(random.nextLong());
        result.setRepresentativeId(representativeId);
        result.setSpanningVector(spanningVector);
        result.setMemberIds(memberIds);
        result.setVersion(System.currentTimeMillis());

        clusters.put(result.getId(), result);
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
        InMemoryCluster oldCluster = clusters.get(cluster.getId());

        if (oldCluster.getVersion() != cluster.getVersion())
        {
            throw new DataInconsistencyException(
                "Version of cluster changed while performing update. Updated cluster will not be written.");
        }

        clusters.replace(cluster.getId(), cluster);
    }
}