class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        double rand = Math.random();
        if (rand < 0.33) {
            return new RoadTile();
        } else if (rand < 0.66) {
            return new ForestTile();
        } else {
            return new BuildingTile();
        }
    }
}