package ua.nung.edu.pz.model;

import java.util.Objects;

public class Types {
    private long id;
    private String name;
    private String deleted_at;

    public  Types() {

    }

    public Types(long id,String name, String deleted_at) {
        this.id = id;
        this.name = name;
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "GoodsTypes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Types that = (Types) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(deleted_at, that.deleted_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deleted_at);
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
