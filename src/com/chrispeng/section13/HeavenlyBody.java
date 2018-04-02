package com.chrispeng.section13;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody
{
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyType {
        START,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTERIOD
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType)
    {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public Key getKey() {
        return key;
    }

    public static Key makeKey(String name, BodyType bodyType)
    {
        return new Key(name, bodyType);
    }

    public double getOrbitalPeriod()
    {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon)
    {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites()
    {
        return new HashSet<>(satellites);
    }

    @Override
    public final int hashCode()
    {
        return this.key.hashCode();
    }

    @Override
    public final boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public String toString()
    {
        return this.key + ", " + this.orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyType bodyType;

        private Key(String name, BodyType bodyType)
        {
            this.name = name;
            this.bodyType = bodyType;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 57;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.name.equals(key.getName())
                    && this.bodyType.equals(key.getBodyType());
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }

        public String getName()
        {
            return name;
        }
    }
}
