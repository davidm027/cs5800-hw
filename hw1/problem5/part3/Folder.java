package problem5.part3;

import java.util.ArrayList;

public class Folder {
    private String name;
    private ArrayList<Folder> folders;
    private ArrayList<File> files;

    public Folder(String name, ArrayList<Folder> folders, ArrayList<File> files) {
        this.name = name;
        this.folders = folders;
        this.files = files;
    }

    public Folder(String name) {
        this.name = name;
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Folder> getFolders() {
        return this.folders;
    }

    public void setFolders(ArrayList<Folder> folders) {
        this.folders = folders;
    }

    public ArrayList<File> getFiles() {
        return this.files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.printSubdirs(""));
        sb.append(this.printFiles());
        return sb.toString();
    }

    private StringBuilder printSubdirs(String padding) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName() + "\n");
        if (!(this.getFolders().isEmpty())) {
            for (int i = 0; i < this.getFolders().size(); i++) {
                String bar = (i == this.getFolders().size() - 1) ? "└─ " : "├─ ";
                Folder fo = this.getFolders().get(i);
                sb.append(padding + bar + fo.printSubdirs(padding + "│  "));
            }
        }
        return sb;
    }

    private StringBuilder printFiles() {
        StringBuilder sb = new StringBuilder();
        if (!(this.getFiles().isEmpty())) {
            for (File fi : this.getFiles()) {
                sb.append("└─ " + fi);
            }
        }
        return sb;
    }
}