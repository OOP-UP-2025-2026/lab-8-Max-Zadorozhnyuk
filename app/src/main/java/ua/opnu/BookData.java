package ua.opnu;

public class BookData implements Comparable<BookData> {
    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public double getRating() {
        return reviews == 0 ? 0 : total / reviews;
    }

    @Override
    public int compareTo(BookData o) {
        int cmp = Double.compare(o.getRating(), this.getRating());
        return cmp != 0 ? cmp : this.title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return title + " (" + getRating() + ")";
    }
}