package ru.bublinoid.otusbasic.entity;

public class Horse implements Transport {

    @Override
    public String getType() {
        return "лошадь";
    }

    @Override
    public boolean move(int distance, TerrainType terrainType, Rider rider) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("Лошадь не может переместиться по болоту");
            return false;
        }

        if (rider.hasEnoughEnergy(distance)) {
            rider.decreaseEnergy(distance);
            return true;
        } else {
            System.out.println(rider.getName() + " недостаточно сил для перемещения на " + distance + " км");
            return false;
        }
    }
}
