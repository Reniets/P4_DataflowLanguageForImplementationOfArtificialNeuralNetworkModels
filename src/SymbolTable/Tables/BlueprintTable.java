package SymbolTable.Tables;

import SymbolTable.Entries.VariableEntry;
import SymbolTable.SymbolType;

import java.util.HashMap;

public class BlueprintTable implements Table {
    private HashMap<String, VariableEntry> table;
    private VariableEntry newEntry;

    public BlueprintTable() {
        this.table = new HashMap<>();
    }

    public void setNewEntry(String id, SymbolType symbolType) {
        VariableEntry entry = new VariableEntry(id, symbolType);
        this.table.put(id, entry);
        this.newEntry = entry;
    }

    public VariableEntry getNewEntry() {
        return this.newEntry;
    }
}
