package com.github.yombu.heimdall;

import javax.annotation.Nonnull;

public interface ItemStore<I>
{
    @Nonnull
    ClusterItem<I> read(I id);
}