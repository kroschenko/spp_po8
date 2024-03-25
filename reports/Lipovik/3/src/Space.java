public class Space {
    private int spaceStart;
    private int spaceEnd;
    private File file;
    Space(int _spaceStart, int _spaceEnd){
        spaceStart=_spaceStart;
        spaceEnd=_spaceEnd;
    }

    public void setSpaceStart(int spaceStart) {
        this.spaceStart = spaceStart;
    }

    public void setSpaceEnd(int spaceEnd) {
        this.spaceEnd = spaceEnd;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getSpaceStart() {
        return spaceStart;
    }

    public int getSpaceEnd() {
        return spaceEnd;
    }

    public File getFile() {
        return file;
    }
    @Override
    public String toString() {
        String result="";
        result +="begin: "+spaceStart+" end: "+spaceEnd;
        return result;
    }
}
