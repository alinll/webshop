package ua.nung.edu.pz.model;

import java.util.Objects;

public class Price {
    private long id;
    private long good_id;
    private double from_supplier;
    private double for_client;
    private String created_at;
    private String deleted_at;

    public Price() {

    }

    public long getGood_id() {
        return good_id;
    }

    public void setGood_id(long good_id) {
        this.good_id = good_id;
    }

    public Price(long id, long good_id, double from_supplier, double for_client, String created_at, String deleted_at) {
        this.id = id;
        this.good_id = good_id;
        this.from_supplier = from_supplier;
        this.for_client = for_client;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return id == price.id && good_id == price.good_id && Double.compare(from_supplier, price.from_supplier) == 0 && Double.compare(for_client, price.for_client) == 0 && Objects.equals(created_at, price.created_at) && Objects.equals(deleted_at, price.deleted_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, good_id, from_supplier, for_client, created_at, deleted_at);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", good_id=" + good_id +
                ", from_supplier=" + from_supplier +
                ", for_client=" + for_client +
                ", created_at='" + created_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getFor_client() {
        return for_client;
    }

    public void setFor_client(double for_client) {
        this.for_client = for_client;
    }

    public double getFrom_supplier() {
        return from_supplier;
    }

    public void setFrom_supplier(double from_supplier) {
        this.from_supplier = from_supplier;
    }
}
