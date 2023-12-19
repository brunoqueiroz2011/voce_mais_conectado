package Singletons;

public class SaveDataMemory {

    private static SaveDataMemory instance;

    public static SaveDataMemory getInstance() {
        if (instance == null) {
            instance = new SaveDataMemory();
        }
        return instance;
    }
}
