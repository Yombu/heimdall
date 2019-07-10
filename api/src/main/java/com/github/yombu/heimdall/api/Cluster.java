package com.github.yombu.heimdall.api;

import java.util.List;
import java.util.Map;

public interface Cluster<I>
{
    I getRepresentativeId();

    void setRepresentativeId(I id);

    Map<String, Double> getSpanningVector();

    void setSpanningVector(Map<String, Double> spanningVector);

    List<I> getMemberIds();

    void setMemberIds(List<I> memberIds);
}