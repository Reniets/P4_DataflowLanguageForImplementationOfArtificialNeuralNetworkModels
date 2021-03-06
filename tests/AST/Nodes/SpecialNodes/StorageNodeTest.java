package AST.Nodes.SpecialNodes;

import AST.Nodes.NodeClasses.NamedNodes.NamedIdNodes.BlockNode;
import java_cup.runtime.ComplexSymbolFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StorageNodeTest {

    private StorageNode storageNodeNoName;
    private StorageNode storageNodeName;
    private BlockNode blockNode;

    @BeforeEach
    void beforeEach() {
        blockNode = new BlockNode("blockNodeId", new ComplexSymbolFactory.Location(-1, -1));
        storageNodeNoName = new StorageNode(blockNode);
        storageNodeName = new StorageNode("name", blockNode);
    }

    @Test
    void getNodes() {
        assertEquals(blockNode, storageNodeNoName.getNodes()[0]);
    }

    @Test
    void getName01() {
        assertEquals("NoName", storageNodeNoName.getName());
    }

    @Test
    void getName02() {
        assertEquals("name", storageNodeName.getName());
    }
}