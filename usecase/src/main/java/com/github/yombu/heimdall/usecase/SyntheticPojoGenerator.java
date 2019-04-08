package com.github.yombu.heimdall.usecase;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class SyntheticPojoGenerator
{
    private final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Random random = new Random();

    public List<Pojo> generate(Integer times)
    {
        List<Pojo> pojos = Lists.newArrayList();

        for (int i = 0; i < times; i++)
        {
            Pojo pojo = new Pojo();
            pojo.setId(random.nextInt());
            pojo.setFirstname(newRandomString());
            pojo.setLastname(newRandomString());
            pojo.setDescription(newRandomString());
            pojo.setVersion(random.nextLong());

            pojos.add(pojo);
        }
        return pojos;
    }

    private String newRandomString()
    {
        StringBuilder builder = new StringBuilder();
        while (builder.length() < random.nextInt(9) + 6)
        {
            builder.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }

        return builder.toString();
    }
}