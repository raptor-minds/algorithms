package percolation.fundamentals;

import edu.princeton.cs.algs4.Queue;

import java.io.File;

public class ListingFile {

    private final static Queue<String> queue = new Queue<>();
    private static String rootPath = null;

    void getFileName(String fold) {
        File[] files = new File(fold).listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                getFileName(file.getPath());
            } else {
                queue.enqueue(file.getName());
                System.out.println(ListingFile.queue.size() + " enqueue : " + file.getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        ;
    }

    Runnable enqueue = () -> {
        getFileName(ListingFile.rootPath);
    };

    Runnable dequeue = () -> {
        while (true) {
            while (!ListingFile.queue.isEmpty()) {
                String file = ListingFile.queue.dequeue();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("size: " + ListingFile.queue.size() + " dequeue and file Name is : " + file);
            }
        }
    };

    public static void main(String[] args) {
        String foldName = args[0];
        ListingFile.rootPath = foldName;
        System.out.println(ListingFile.rootPath);
        ListingFile listingFile = new ListingFile();
        Thread thread = new Thread(listingFile.enqueue);
        thread.start();
        Thread thread1 = new Thread(listingFile.dequeue);
        thread1.start();
//        listingFile.getFileName(ListingFile.rootPath);
//        for (String file : ListingFile.queue) {
//            System.out.println(file);
//        }
//
//        while (!ListingFile.queue.isEmpty()){
//            String file = ListingFile.queue.dequeue();
//            System.out.println("size: " + ListingFile.queue.size() + " file Name is : " + file);
//        }
    }
}
