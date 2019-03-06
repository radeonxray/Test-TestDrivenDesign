public class Item {

    private int id;
    private String text;
    private float price;

    public Item(int id, String text, float price) {
        this.id = id;
        this.text = text;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }


    public float getPrice() {
        return price;
    }

}
