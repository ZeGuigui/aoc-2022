package fr.zeguigui.adventofcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory {

    private final Directory parentDirectory;
    private final String directoryName;
    private final Map<String,Directory> subDirectories = new HashMap<>();
    private final Map<String,Long> files = new HashMap<>();

    public Directory(String name, Directory parentDirectory) {
        this.directoryName = name;
        this.parentDirectory = parentDirectory;
    }

    public String getName() {
        return this.directoryName;
    }

    public long getTotalSize() {
        long size = 0;
        for (long s : files.values()) {
            size += s;
        }
        for (Directory d : subDirectories.values()) {
            size += d.getTotalSize();
        }
        return size;
    }

    public Collection<Directory> getSubdirectories() {
        return this.subDirectories.values();
    }

    public static List<Directory> filterDirectoryBySize(Directory d, long maximumSize) {
        List<Directory> result = new ArrayList<>();
        if (d.getTotalSize() <= maximumSize) {
            result.add(d);
        }
        for (Directory subdir : d.getSubdirectories()) {
            result.addAll(filterDirectoryBySize(subdir, maximumSize));
        }
        return result;
    }

    public static List<Directory> filterDirectoryByMinSize(Directory d, long minimumSize) {
        List<Directory> result = new ArrayList<>();
        if (d.getTotalSize() >= minimumSize) {
            result.add(d);
        }
        for (Directory subdir : d.getSubdirectories()) {
            result.addAll(filterDirectoryByMinSize(subdir, minimumSize));
        }
        return result;
    }


    public void addDirectory (String directoryName) {
        this.subDirectories.put(directoryName, new Directory(directoryName, this));
    }

    public Directory getDirectory(String directoryName) {
        return this.subDirectories.get(directoryName);
    }

    public void addFile(String name, long size) {
        this.files.put(name, size);
    }

    public Directory getParentDirectory() {
        return this.parentDirectory;
    }

    /**
     * Parse line and return new currentDirectory if necessary
     * @param line input line
     * @return new current directory
     */
    public Directory parseLine(String line) {
        if (line.equals("$ cd ..")) {
            return this.getParentDirectory();
        }
        if (line.equals("$ ls")) {
            return this;
        }
        if (line.startsWith("dir ")) {
            this.addDirectory(line.substring(4));
            return this;
        }
        if (line.equals("$ cd /")) {
            Directory rootDirectory = this;
            while (rootDirectory.getParentDirectory() != null) {
                rootDirectory = rootDirectory.getParentDirectory();
            }
            return rootDirectory;
        }
        if (line.startsWith("$ cd")) {
            return getDirectory(line.substring(5));
        }
        // This is a file
        String[] fileElements = line.split(" ",2);
        this.addFile(fileElements[1], Long.parseLong(fileElements[0]));
        return this;
    }

}
