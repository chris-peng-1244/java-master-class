package com.chrispeng.section13;

public class Planet extends HeavenlyBody
{
    public Planet(String name, double orbintalPeriod)
    {
        super(name, orbintalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon)
    {
        return moon.getKey().getBodyType() == BodyType.MOON &&
                super.addSatellite(moon);
    }
}
