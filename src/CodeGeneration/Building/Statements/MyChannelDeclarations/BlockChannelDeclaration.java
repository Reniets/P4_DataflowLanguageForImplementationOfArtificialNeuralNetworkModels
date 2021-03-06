package CodeGeneration.Building.Statements.MyChannelDeclarations;

import CodeGeneration.Building.Statement;

public abstract class BlockChannelDeclaration implements Statement {

    // Field:
    protected String channelId;

    @Override
    public String toString() {
        return "(\"" + this.channelId + "\", new ListChannel())";
    }
}

