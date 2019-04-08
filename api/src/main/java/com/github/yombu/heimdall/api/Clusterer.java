package com.github.yombu.heimdall.api;

import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.github.mizool.core.exception.UnprocessableEntityException;
import info.debatty.java.stringsimilarity.Damerau;

@Slf4j
@RequiredArgsConstructor
public class Clusterer<I, C extends Cluster<I>>
{
    private final ClusterStore<I, C> clusterStore;
    private final ItemStore<I> itemStore;
    private final Map<String, Double> weighting;
    private final Damerau damerau = new Damerau();

    @Getter
    @RequiredArgsConstructor
    private class ScoredCluster
    {
        private final Double score;
        private final C cluster;
    }

    public Cluster<I> addToCluster(ClusterItem<I> item) throws UnprocessableEntityException
    {
        C highscoreCluster = null;
        //to be implemented
        return highscoreCluster;
    }

    private void replaceItemInCluster(I itemToBeReplaced, C cluster, I newItem)
    {
        cluster.getMemberIds().remove(itemToBeReplaced);
        cluster.getMemberIds().add(newItem);
        clusterStore.save(cluster);
    }

    //Think about a public version of this as well. Keep in mind that this will be a costly operation
    //as the database item won't know it's corresponding cluster and we have to search for it
    private void removeFromCluster(I clusterItemId, C cluster)
    {
        cluster.getMemberIds().remove(clusterItemId);
        clusterStore.save(cluster);
    }
}