package com.github.yombu.heimdall;

import java.util.Map;

import lombok.Data;

@Data
public class ClusterItem<I>
{
    private I id;
    private Map<String, String> payload;
}