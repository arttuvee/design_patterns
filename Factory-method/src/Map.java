abstract class Map {
    protected int width;
    protected int height;
    protected Tile[][] tiles;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
        generateMap();
    }

    protected void generateMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    protected abstract Tile createTile();
}