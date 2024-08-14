package ru.bublinoid.otusbasic.entity;

interface Transport {
    String getType();

    boolean move(int distance, TerrainType terrainType, Rider rider);
}
