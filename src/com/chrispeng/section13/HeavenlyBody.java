package com.chrispeng.section13;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody
{
    private final String name;
    private final String bodyType;
    private final double orbitalPeriod;
    private final Set<Moon> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, String bodyType)
    {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = bodyType;
        this.satellites = new HashSet<>();
    }

    public String getName()
    {
        return name;
    }

    public String getBodyType()
    {
        return bodyType;
    }

    public double getOrbitalPeriod()
    {
        return orbitalPeriod;
    }

    public boolean addMoon(Moon moon)
    {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites()
    {
        return new HashSet<>(satellites);
    }

    @Override
    public int hashCode()
    {
        System.out.println("hashCode called");
        return this.name.hashCode() + 57 + this.bodyType.hashCode() + 91;
    }

    @Override
    public final boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        if(!this.name.equals(objName)) {
            return false;
        }

        String objType = ((HeavenlyBody) obj).getBodyType();
        return this.getBodyType().equals(objType);
    }
}
