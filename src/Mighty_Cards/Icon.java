package Mighty_Cards;

public class Icon {

    private int id;
    private int ratingLock;
    private String fileName;

    /**
     *
     * @param id
     * @param ratinglock
     * @param filename
     */
    public Icon(int id, int ratinglock, String filename) {
        this.id = id;
        this.ratingLock = ratinglock;
        this.fileName = filename;
    }

    public int getId() {
        return this.id;
    }

    public int getRatingLock() {
        return this.ratingLock;
    }

    public String getFileName() {
        return this.fileName;
    }

}
