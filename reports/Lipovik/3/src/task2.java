public class task2 {
    public static void main(String[] args){
        Disk disk = new Disk();
        File file1 = new File("a.txt", 700);
        File directory = new File ("a");
        File file3 = new File("a/c.txt", 300);
        File file2 = new File("a/b.txt", 300);
        File file4 = new File("d.txt", 400);
        System.out.println("Add file1, directory, file2 and file3");
        disk.addFile(file1);
        disk.addFile(directory);
        disk.addFile(file3);
        disk.addFile(file2);
        disk.printOccupiedSpace();
        System.out.println("delete directory with file2 and file3");
        disk.deleteFile(directory);
        disk.printFreeSpace();
        disk.printOccupiedSpace();
        System.out.println("Add file2 and file3");
        disk.addFile(file3);
        disk.addFile(file2);
        System.out.println("delete file3");
        disk.deleteFile(file3);
        System.out.println("Add file4");
        disk.addFile(file4);
    }
}
