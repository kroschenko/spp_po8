import java.util.ArrayList;

public class Disk {
    private ArrayList<Space> freeSpace = new ArrayList<>();
    private ArrayList<Space> occupiedSpace = new ArrayList<>();
    Disk(){
        freeSpace.add(new Space(1, 1440));
    }
    public void addFile(File file){
        if(file.getType().equals("D")){
            Space directorySpace = new Space(0, 0);
            directorySpace.setFile(file);
            occupiedSpace.add(directorySpace);
            return;
        }
        for(Space space:freeSpace){
            if((space.getSpaceEnd()- space.getSpaceStart())> file.getSize()){
                Space newSpace= new Space(space.getSpaceStart(), space.getSpaceStart()+file.getSize()-1);
                newSpace.setFile(file);
                occupiedSpace.add(newSpace);
                space.setSpaceStart(space.getSpaceStart()+file.getSize());
                return;
            }
        }
        System.out.println("not enough free space!");
    }
    public void deleteFile(File file){
        if(file.getType()=="D"){
            Space directorySpace=null;
            String directoryPath="";
            if(!file.getParentDirectoryPath().isEmpty()){
                directoryPath+=file.getParentDirectoryPath()+"/";
            }
            directoryPath+=file.getName()+"/";
            Space space;
            for(int i =0;i<occupiedSpace.size();i++){
                space=occupiedSpace.get(i);
                if(space.getFile().getParentDirectoryPath().equals(directoryPath)){
                    deleteFile(space.getFile());
                    i--;
                }
                if(space.getFile()==file){
                    directorySpace=space;
                }
            }
            occupiedSpace.remove(directorySpace);
            return;
        }
        for(Space space:occupiedSpace){
            if(space.getFile() == file){

                Space rightSpace = null, leftSpace=null;
                for(Space fSpace:freeSpace){
                    if(fSpace.getSpaceStart() == space.getSpaceEnd()+1){
                        rightSpace=fSpace;
                        continue;
                    }
                    if(fSpace.getSpaceEnd() == space.getSpaceStart()-1){
                        leftSpace=fSpace;
                    }
                }
                if(rightSpace != null && leftSpace!=null){
                    leftSpace.setSpaceEnd(rightSpace.getSpaceEnd());
                    occupiedSpace.remove(space);
                    freeSpace.remove(rightSpace);
                    return;
                }
                else if(rightSpace != null && leftSpace==null){
                    rightSpace.setSpaceStart(space.getSpaceStart());
                    occupiedSpace.remove(space);
                    return;
                }
                else if(rightSpace == null && leftSpace!=null){
                    leftSpace.setSpaceEnd(space.getSpaceEnd());
                    occupiedSpace.remove(space);
                    return;
                }
                else if(rightSpace == null && leftSpace==null){
                    occupiedSpace.remove(space);
                    space.setFile(null);
                    freeSpace.add(space);
                    return;
                }
            }
        }
    }
    public void printFreeSpace(){
        System.out.println("free spaces:");
        for(Space space:freeSpace){
            System.out.println(space);
        }
    }
    public void printOccupiedSpace(){
        System.out.println("occupied spaces:");
        for(Space space:occupiedSpace){
            if(!space.getFile().getType().equals("D")) {
                System.out.println(space);
                System.out.println(space.getFile());
            }
        }
    }
}
