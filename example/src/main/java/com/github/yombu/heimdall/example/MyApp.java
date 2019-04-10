package com.github.yombu.heimdall.example;

import java.util.List;

import com.github.yombu.heimdall.api.ClusterItem;
import com.github.yombu.heimdall.api.ClusterStore;
import com.github.yombu.heimdall.api.Clusterer;
import com.github.yombu.heimdall.impl.InMemoryCluster;
import com.github.yombu.heimdall.impl.InMemoryClusterStore;
import com.github.yombu.heimdall.impl.InMemoryItemStore;
import com.google.common.collect.Lists;

public class MyApp
{
    private SyntheticPojoGenerator syntheticPojoGenerator = new SyntheticPojoGenerator();
    private PojoConverter pojoConverter = new PojoConverter();
    private ClusterStore<Integer, InMemoryCluster> clusterStore = new InMemoryClusterStore();
    private InMemoryItemStore itemStore = new InMemoryItemStore();

    public void run()
    {
        List<ClusterItem<Integer>> clusterItems = generateItems(20);
        clusterItems.forEach(itemStore::add);

        Clusterer<Integer, InMemoryCluster> clusterer = new Clusterer<>(clusterStore, itemStore, null);
        clusterItems.forEach(clusterer::addToCluster);

        System.out.println("The following clusters were generated: ");
        clusterStore.list().forEach(System.out::println);
    }

    private List<ClusterItem<Integer>> generateItems(int times)
    {
        List<ClusterItem<Integer>> result = Lists.newArrayList();
        List<Pojo> pojos = syntheticPojoGenerator.generate(times);
        pojos.forEach(pojo -> result.add(pojoConverter.fromPojo(pojo)));

        return result;
    }
}