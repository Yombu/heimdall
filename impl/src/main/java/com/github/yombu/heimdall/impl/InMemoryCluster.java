package com.github.yombu.heimdall.impl;

import java.util.List;
import java.util.Map;

import lombok.Data;

import com.github.yombu.heimdall.api.Cluster;

@Data
public class InMemoryCluster implements Cluster<Integer>
{
    private Integer representativeId;
    private Map<String, Double> spanningVector;
    private List<Integer> memberIds;
    private long version;
}