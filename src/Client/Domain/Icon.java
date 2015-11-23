package Client.Domain;

/**
 * An class contianing basic information about an icon
 */
public class Icon {

    private final int id;
    private final int ratingLock;
    private final String fileName;

    /**
     * Create a new instance of Icon
     * @param id the icon id
     * @param ratinglock the icon rating cap
     * @param filename the icon filename
     */
    public Icon(int id, int ratinglock, String filename) {
        this.id = id;
        this.ratingLock = ratinglock;
        this.fileName = filename;
    }

    /**
     * Get the icon id
     * @return the ID from the icon
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get the ratingLock of the card
     * @return the rating cap from the icon
     */
    public int getRatingLock() {
        return this.ratingLock;
    }

    /**
     * Get the filename of the image of the card(inside the jar)
     * @return the filename of the icon
     */
    public String getFileName() {
        return this.fileName;
    }

}
