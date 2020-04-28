public class OffByN implements CharacterComparator {

    int charDiff;
    public OffByN(int N) {
        charDiff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == charDiff;
    }
}
