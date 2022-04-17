package sv.edu.udb.ml161665.farmaciamedica;

public class Data {
    private int Id;
    private String Name;
    private String Price;
    private int Image;

    public Data(int id, String name, String price, int image) {
        Id = id;
        Name = name;
        Price = price;
        Image = image;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
