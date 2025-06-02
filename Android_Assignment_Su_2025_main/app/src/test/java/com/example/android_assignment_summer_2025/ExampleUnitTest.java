package com.example.android_assignment_summer_2025;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    // TODO 7: Write a unit test for ensuring correct behavior of the addMedia function you implemented in TODO 2 in MediaManagerSingleton
    @Test
    public void testAddMediaFunction() {
        // Get the singleton instance
        MediaManagerSingleton manager = MediaManagerSingleton.getInstance();
        
        // Get initial size of content list
        int initialSize = manager.getContent().size();
        
        // Create a test media item
        Media testMedia = new Media("Test Movie");
        
        // Add the media using the addMedia function
        manager.addMedia(testMedia);
        
        // Verify that the content list size increased by 1
        assertEquals(initialSize + 1, manager.getContent().size());
        
        // Verify that the added media is in the list
        assertTrue(manager.getContent().contains(testMedia));
        
        // Verify that the media description is correct
        assertEquals("Test Movie", testMedia.getDescription());
    }
}