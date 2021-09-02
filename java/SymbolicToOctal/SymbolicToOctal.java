public class SymbolicToOctal{
  
    public static int charValue(String chara) {
        if (chara.equalsIgnoreCase("r")) {
            return 4;
        } else if (chara.equalsIgnoreCase("w")) {
            return 2;
        } else if (chara.equalsIgnoreCase("x")) {
            return 1;
        } else return 0;
    }

    private static String calculateSymbolValue(String symbol, int i, int i2) {
        return Arrays.stream(symbol.substring(i, i2).split("")).map(s -> charValue(s)).collect(Collectors.summingInt(Integer::intValue)).toString();
    }

    public static int calculateSymbol(String symbol) {
        String symbolValue1 = calculateSymbolValue(symbol, 0, 3);
        String symbolValue2 = calculateSymbolValue(symbol, 3, 6);
        String symbolValue3 = calculateSymbolValue(symbol, 6, 9);
        return Integer.valueOf(symbolValue1 + symbolValue2 + symbolValue3);
    }

    public static int symbolicToOctal(String permString) {
        return calculateSymbol(permString);
    }

    public static void main(String[] args) {
        // Should write 752
        System.out.println(symbolicToOctal("rwxr-x-w-"));
    }
}
