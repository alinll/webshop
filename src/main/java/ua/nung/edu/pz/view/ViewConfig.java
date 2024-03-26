package ua.nung.edu.pz.view;

public class ViewConfig {
    private String path;

    private static ViewConfig viewConfig = new ViewConfig();
    private ViewConfig() {}
    public static ViewConfig getInstance() {
        return viewConfig;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}