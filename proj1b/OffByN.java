public class OffByN implements CharacterComparator {
    private int offset;

    public OffByN(int off) {
        offset = off;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == offset) {
            return true;
        }
        return false;
    }
}
