package thread.sync.test;

public class Immutable {
    private final int value; // 안전한 공유자원

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
        
    }
}
