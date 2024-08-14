package ru.bublinoid.otusbasic.entity;

public class OffRoadVehicle implements Transport {

    @Override
    public String getType() {
        return "вездеход";
    }

    @Override
    public boolean move(int distance, TerrainType terrainType, Rider rider) {
        System.out.println("Вездеход успешно перемещается на " + distance + " км по " + getTerrainDescription(terrainType));
        return true;
    }

    private String getTerrainDescription(TerrainType terrainType) {
        switch (terrainType) {
            case DENSE_FOREST:
                return "густому лесу";
            case PLAIN:
                return "равнине";
            case SWAMP:
                return "болоту";
            default:
                return "неизвестной местности";
        }
    }
}
