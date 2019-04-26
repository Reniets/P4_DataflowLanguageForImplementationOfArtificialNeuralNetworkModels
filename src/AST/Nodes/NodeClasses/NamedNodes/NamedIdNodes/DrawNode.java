package AST.Nodes.NodeClasses.NamedNodes.NamedIdNodes;

import AST.Enums.NodeEnum;
import AST.Nodes.AbstractNodes.Nodes.AbstractNodes.NumberedNodes.NamedNodes.NamedIdNode;

public class DrawNode extends NamedIdNode {
    public DrawNode(String id) {
        super("Draw", id, NodeEnum.DRAW);
    }
}