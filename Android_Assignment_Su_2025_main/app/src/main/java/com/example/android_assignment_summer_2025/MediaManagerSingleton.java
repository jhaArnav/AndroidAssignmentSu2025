package com.example.android_assignment_summer_2025;
import java.util.ArrayList;
import java.util.List;
public class MediaManagerSingleton {
    private static MediaManagerSingleton instance;
    private List<Media> content;

    // DO NOT MODIFY!
    private MediaManagerSingleton() {
        content = new ArrayList<>();
    }

    // DO NOT MODIFY!
    public static MediaManagerSingleton getInstance() {
        if (instance == null) {
            instance = new MediaManagerSingleton();
        }
        return instance;
    }

    // TODO 2: Implement addMedia functionality
    // HINT: look at the data structure type!
    public void addMedia(Media media) {
        content.add(media);
    }

    public List<Media> getContent() {
        return content;
    }

}
