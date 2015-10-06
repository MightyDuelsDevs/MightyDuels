package Mighty_Cards;

public class Icon {

    private int id;
    private int ratingLock;
    private String fileName;

    /**
     *
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
     * 
     * @return the ID from the icon
     */
    public int getId() {
        return this.id;
    }

    /**
     * 
     * @return the rating cap from the icon
     */
    public int getRatingLock() {
        return this.ratingLock;
    }

    /**
     * 
     * @return the filename of the icon
     */
    public String getFileName() {
        return this.fileName;
    }

}
