package model; 
public class Species {
    private String name;
    private String type;
    private String photoUrl;
    private int specimenCount;

    // Constructor
    public Species(String name, String type, String photoUrl, int specimenCount) {
        this.name = name;
        this.type = type;
        this.photoUrl = photoUrl;
        this.specimenCount = specimenCount;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getSpecimenCount() {
        return specimenCount;
    }

    public void setSpecimenCount(int specimenCount) {
        this.specimenCount = specimenCount;
    }
}
