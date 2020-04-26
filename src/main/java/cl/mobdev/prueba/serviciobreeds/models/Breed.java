package cl.mobdev.prueba.serviciobreeds.models;

public class Breed {
    private String breed;
    private String[] subBreeds;
    private Image[] images;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String[] getSubBreeds() {
        return subBreeds;
    }

    public void setSubBreeds(String[] subBreeds) {
        this.subBreeds = subBreeds;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }
}
