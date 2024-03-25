import java.util.Arrays;

public class File {
    private String name;
    private int size;
    private String type;
    private String extension;

    private String parentDirectoryPath;
    File(String _name,int _size){
        String[] words = _name.split("/");
        name=words[words.length-1];
        words = name.split("\\.");
        extension = words[words.length-1];
        size=_size;
        parentDirectoryPath = _name.substring(0, _name.length()-name.length());
        type="F";
    }
    File(String _name){
        name=_name;
        parentDirectoryPath = _name.substring(0, _name.length()-name.length());
        type="D";
    }
    @Override
    public String toString(){
        String result="";
        if(type.equals("D")){
            result+="name: "+name;
        }
        else{
            String[] words = name.split("\\.");
            result+="name: "+words[0]+" size: "+size+" extension: "+extension;
        }
        return result;
    }
    public void setName(String _name){
        name=_name;
    }
    public void setParentDirectoryPath(String _parentDirectoryPath){
        parentDirectoryPath=_parentDirectoryPath;
    }

    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }

    public String getExtension() {
        return extension;
    }

    public String getParentDirectoryPath() {
        return parentDirectoryPath;
    }

    public String getType() {
        return type;
    }
}
