package com.github.yombu.heimdall.api;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface ClusterStore<I, C extends Cluster<I>>
{
    C create(I representativeId, Map<String, Double> spanningVector, List<I> memberIds);

    Stream<C> list();

    void update(C cluster);
}