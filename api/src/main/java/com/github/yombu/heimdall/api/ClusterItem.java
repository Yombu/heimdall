package com.github.yombu.heimdall.api;

import java.util.Map;

import lombok.Value;

@Value
public class ClusterItem<I>
{
    private I id;
    private Map<String, String> payload;
}