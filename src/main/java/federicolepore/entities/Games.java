package federicolepore.entities;

public abstract class Games {
    //    attributi
    private final long id;
    private final String title;
    private final int year;
    private double price;


    public Games(long id, String title, int year, double price) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;

    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getClass() +
                "{ id=" + id +
                ", title= " + title +
                ", anno= " + year +
                ", prezzo= " + price;
    }
}
