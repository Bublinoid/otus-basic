package ru.bublinoid.otusbasic.entity;

public class Human {
    private String name;
    private Transport currentTransport;
    private Rider rider;

    public Human(String name, int initialEnergy) {
        this.name = name;
        this.rider = new Rider(name, initialEnergy);
    }

    public void sitOnTransport(Transport transport) {
        if (currentTransport == null) {
            currentTransport = transport;
            System.out.println(name + " сел в " + transport.getType());
        } else {
            System.out.println(name + " уже находится в транспорте");
        }
    }

    public void getOffTransport() {
        if (currentTransport != null) {
            System.out.println(name + " слез с " + currentTransport.getType());
            currentTransport = null;
        } else {
            System.out.println(name + " не находится в транспорте");
        }
    }

    public void move(int distance, TerrainType terrainType) {
        if (currentTransport != null) {
            boolean success = currentTransport.move(distance, terrainType, rider);

            if (!success) {
                System.out.println(name + " не удалось переместиться на " + distance + " км на " +
                        currentTransport.getType() + " по " + getTerrainDescription(terrainType) +
                        " из-за ограничений местности");
            }

        } else {
            System.out.println(name + " идет пешком на " + distance + " км по " + getTerrainDescription(terrainType));
            rider.decreaseEnergy(distance);
        }
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
                return "";
        }
    }
}
