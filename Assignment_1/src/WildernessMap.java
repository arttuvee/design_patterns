class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        double rand = Math.random();
        if (rand < 0.33) {
            return new SwampTile();
        } else if (rand < 0.66) {
            return new WaterTile();
        } else {
            return new ForestTile();
        }
    }
}