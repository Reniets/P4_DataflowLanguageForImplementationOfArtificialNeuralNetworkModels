package CodeGeneration.Building.Statements.VariableDeclarations.Enums;

public enum JavaTypes {
    BLOCK("Block"),
    OPERATION("Operation"),
    SOURCE("Source"),
    SIZE("Pair<Integer, Integer>"),
    CHANNEL("Channel");

    private String str;

    JavaTypes(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
