package com.github.yombu.heimdall.api;

import java.util.Map;

import lombok.Data;

@Data
public class ClusterItem<I>
{
    private I id;
    private Map<String, String> payload;
}